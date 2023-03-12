package com.myjavacode.misc;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class JsonProcessing {

    public static void main(String[] args) {
        String abc = "{phonetype:N95,cat:WP}";

        Gson gson = new Gson();
        Map<String, String> map = gson.fromJson(abc, HashMap.class);

        System.out.println(map.get("phonetype"));
    }
}

