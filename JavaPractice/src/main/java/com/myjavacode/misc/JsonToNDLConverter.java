package com.myjavacode.misc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class JsonToNDLConverter {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/um-143-user/Downloads/branch_ad_spend_click_11_05.json");

        try (InputStream inputStream = Files.newInputStream(path)) {
            InputStream stream = convertToJsonNDL(inputStream);
            Path pathNew = Paths.get("/home/um-143-user/Downloads/branch_ad_spend_click_11_05_ndl.json");

            Files.copy(stream, pathNew, StandardCopyOption.REPLACE_EXISTING);

        }
    }

    public static InputStream convert(InputStream input) throws IOException {
        String json = IOUtils.toString(input, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        ArrayNode results = (ArrayNode) node.get("results");
        StringBuilder sb = new StringBuilder();
        for (JsonNode result : results) {
            String resultJson = mapper.writeValueAsString(result);
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(resultJson);
        }
        return IOUtils.toInputStream(sb.toString(), StandardCharsets.UTF_8);
    }

    public static InputStream convertToJsonNDL(InputStream input) throws IOException {
        String json = IOUtils.toString(input, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        List<String> records = new ArrayList<>();
        if (rootNode.isArray()) {
            for (JsonNode childNode : rootNode) {
                records.add(mapper.writeValueAsString(childNode));
            }
        } else if (rootNode.isObject()) {
            records.add(mapper.writeValueAsString(rootNode));
        }

        String ndlJson = String.join("\n", records);
        return IOUtils.toInputStream(ndlJson, StandardCharsets.UTF_8);
    }

}
