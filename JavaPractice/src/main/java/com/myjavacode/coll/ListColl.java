package com.myjavacode.coll;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ListColl {

    public static boolean extractQueueIdFromQueueUrl(URI queueUrl) {

        return Optional.of(Pattern
                .compile("(.*)(/queue/item/)(\\d+)$")
                .matcher(queueUrl.toString())
                .find())
                .get();

    }

    public static void main(String [] args) throws URISyntaxException {

        System.out.println(ListColl.extractQueueIdFromQueueUrl((URI)null));

    }
}
