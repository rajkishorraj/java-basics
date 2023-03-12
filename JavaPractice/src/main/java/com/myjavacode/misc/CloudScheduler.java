package com.myjavacode.misc;

import com.google.cloud.WriteChannel;
import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.logging.Logger;

public class CloudScheduler implements BackgroundFunction<CloudScheduler.PubSubMessage> {
    private static final Logger logger = Logger.getLogger(CloudScheduler.class.getName());
    private static final String APP_ID = "ATP85GRZ6S7Y4UTLE0CQYVQD";
    private static final String REPORT_NAME = "flowone_20221212.zip";
    private static final String SECRET_KEY = "AKAP302RXUHH";
    private static final String MO_ENGAGE_REPORT_URL = "https://api-03.moengage.com/campaign_reports/rest_api/ATP85GRZ6S7Y4UTLE0CQYVQD/" + REPORT_NAME;
    private static final String PROJECT_ID = "original-storm-364708";
    private static final String BUCKET_NAME = "gcf-sources-337428139779-asia-south1";


    @Override
    public void accept(PubSubMessage message, Context context) {
        logger.info("Started execution to fetch moengage report");
        String hashValue = DigestUtils.sha256Hex(APP_ID + "|" + REPORT_NAME + "|" + SECRET_KEY);

        RequestCallback requestCallback = request -> request
                .getHeaders()
                .set("Signature", hashValue);

        ResponseExtractor<Void> responseExtractor = httpResponse -> {
            copyDownloadedFile(httpResponse.getBody());
            return null;
        };

        new RestTemplate().execute(MO_ENGAGE_REPORT_URL, HttpMethod.GET,
                requestCallback, responseExtractor);
    }

    public static class PubSubMessage {
        String data;
        Map<String, String> attributes;
        String messageId;
        String publishTime;
    }

    public void copyDownloadedFile(InputStream inputStream) throws IOException {
        logger.info("Copying report to gcs bucket");
        Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
        BlobId blobId = BlobId.of(BUCKET_NAME, REPORT_NAME);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        logger.info(blobInfo.getName());
        try (WriteChannel writer = storage.writer(blobInfo)) {
            byte[] buffer = new byte[1024];
            int limit;
            while ((limit = inputStream.read(buffer)) >= 0) {
                writer.write(ByteBuffer.wrap(buffer, 0, limit));
            }
        }
        logger.info("Report Copied to bucket");
    }
}
