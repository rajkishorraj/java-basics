package com.myjavacode.security;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.ListSecretVersionsRequest;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.protobuf.ByteString;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class RsaKey {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair with 2048-bit key size
        generateKey();
//        verifyKey();
//        System.out.println(fetchPublicKeyList());

//        destroySecretVersion("smartcoin-dev-test", "random-secret", 2);
//        addSecretVersion("smartcoin-dev-test", "random-secret", "sfskjffdshviufhkjerndfknkjdnfkjdsf");


//        String clientCredentials = "<client_id>" + ":" + "<client_secret>";
//        String encodedString = Base64.getEncoder().encodeToString(clientCredentials.getBytes());
//        String authHeader = "Basic " + encodedString;
    }

    private static void generateKey() throws NoSuchAlgorithmException, FileNotFoundException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get public key
        PublicKey publicKey = keyPair.getPublic();
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());

        // Get private key
        PrivateKey privateKey = keyPair.getPrivate();
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        // Print key pair strings
        System.out.println("Public key: " + publicKeyString);
        System.out.println("Private key: " + privateKeyString);

        try (PrintWriter writer = new PrintWriter("/home/um-143-user/Documents/rsakeypair.txt")) {
            writer.println("\n +++++++++++++++++++++++++++++++++\n public key \n");

            writer.println(publicKeyString);
            writer.println("\n +++++++++++++++++++++++++++++++++\n private key \n");
            writer.println(privateKeyString);
        }
    }

    public static void verifyKey() throws NoSuchAlgorithmException, InvalidKeySpecException {

        String jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2ODI5NjI2MzgsImV4cCI6MTY4Mjk2NDQzOCwiaXNzIjoicGF5dm9vLW9hdXRoLXNlcnZlciIsImNsaWVudF9pZCI6IjM3RUI4MEQwRUUzNjUyODY4MzBDMTMwQTYyMzFGNzY2Iiwib2F1dGhfc2NvcGVfbmFtZSI6ImhlYWx0aC1jaGVjayJ9.RI_EVS84kwtivpulQ35YhnaCTBpWoTAziUcpzd-ndPWJiu63w3AAq5kmbV9ffm22L4u4iJjnDmX8ESzYssqYnQ25RKm6Qo6vHcpn4SCAXIcfndA6nkCliEVN58vzL6j2h-KDVYxwiFdtlQ5lQx-O71W7hKkHUtId7Dl9-cfso-NlboAbX9R_i8DMHpVu6RTCIHla0AA_jea7RbP66kwlT_W0M7LM666QZMcfvhZH8u-e6X8EUDrhMaZ87Wdz_nv0J7vqNQZKh6LZFGI8956ao4MEv5XvOx6j12gTRr6TIbCSPCJVZvS8Kt3YqkHCzbO5WccQwvzNRam2--eFHTyaBw";

        parseTokenWithPublicKey(jwtToken);
    }

    public static Claims parseTokenWithPublicKey(String oauthToken) {
        List<PublicKey> publicKeyList = fetchPublicKeyList();
        RuntimeException lastException = null;

        System.out.println("Signing the token with public key" + publicKeyList);

        for (PublicKey publicKey : publicKeyList) {
            try {
                return Jwts.parser()
                        .setSigningKey(publicKey)
                        .parseClaimsJws(oauthToken)
                        .getBody();
            } catch (Exception exception) {
                lastException = new RuntimeException("Exception while parsing oauthToken", exception);
                System.out.println(exception);
            }
        }

        if (lastException == null) {
            throw new RuntimeException("Could not found public keys:");
        }

        throw lastException;
    }

    public static List<PublicKey> fetchPublicKeyList() {
        List<PublicKey> publicKeyList = new ArrayList<>();

        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            // Build the parent name.
            SecretName secretName = SecretName.of("smartcoin-dev-test", "oauth-public-key");

            SecretManagerServiceClient.ListSecretVersionsPagedResponse pagedResponse = client.listSecretVersions(secretName);

            pagedResponse
                    .iterateAll()
                    .forEach(
                            version -> {
                                AccessSecretVersionResponse accessSecretVersionResponse = client.accessSecretVersion(version.getName());
                                publicKeyList.add(createPublicKey(accessSecretVersionResponse.getPayload().getData().toStringUtf8()));
                            });
        } catch (IOException e) {
            throw new RuntimeException("Exception while fetching public keys");
        }

        return publicKeyList;
    }

    private static PublicKey createPublicKey(String publicKeyString) {
        try {
            return KeyFactory
                    .getInstance("RSA")
                    .generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString)));
        } catch (InvalidKeySpecException | NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void destroySecretVersion(String projectId, String secretId, int numLatestKeysToKeep) {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            String parent = SecretName.format(projectId, secretId);
            ListSecretVersionsRequest request = ListSecretVersionsRequest.newBuilder()
                    .setParent(parent)
                    .build();


            SecretManagerServiceClient.ListSecretVersionsPagedResponse response = client.listSecretVersions(request);

            List<SecretVersion> versions = new ArrayList<>();
            for (SecretVersion version : response.iterateAll()) {
                versions.add(version);
            }

            versions.sort((v1, v2) ->
                    Long.compare(v2.getCreateTime().getSeconds(), v1.getCreateTime().getSeconds())
            );

            for (int i = numLatestKeysToKeep; i < versions.size(); i++) {
                String versionName = versions.get(i).getName();
                client.destroySecretVersion(versionName);
            }

            System.out.println("Deleted the secret versions");

        } catch (IOException e) {
            throw new RuntimeException("Exception while deleting key from secret manager");
        }

       System.out.println("Deleted all the expired keys");
    }

    public static void addSecretVersion(String projectId, String secretId, String value) {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretName secretName = SecretName.of(projectId, secretId);

            SecretPayload payload =
                    SecretPayload.newBuilder()
                            .setData(ByteString.copyFrom(value.getBytes()))
                            .build();

            SecretVersion version = client.addSecretVersion(secretName, payload);
            System.out.println("Added secret version: {}" + version.getName());

        } catch (IOException ioException) {
            throw new RuntimeException("Exception while adding secret version: ", ioException);
        }

        System.out.println("Added the secret version into secretId: {}" + secretId);
    }


}
