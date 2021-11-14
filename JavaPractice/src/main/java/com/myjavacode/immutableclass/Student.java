package com.myjavacode.immutableclass;

import java.util.HashMap;
import java.util.Map;

public final class Student {
    private String name;
    private int regNo;
    private Map<String, String> metadata;

    public Student(String name, int regNo,
                   Map<String, String> metadata)
    {
        this.name = name;
        this.regNo = regNo;
        this.metadata = metadata;
//        Map<String, String> tempMap = new HashMap<>();
//        for (Map.Entry<String, String> entry :
//                metadata.entrySet()) {
//            tempMap.put(entry.getKey(), entry.getValue());
//        }
//        this.metadata = tempMap;
    }

    public String getName() { return name; }

    public int getRegNo() { return regNo; }

    public Map<String, String> getMetadata()
    {
//        Map<String, String> tempMap = new HashMap<>();
//        for (Map.Entry<String, String> entry :
//                this.metadata.entrySet()) {
//            tempMap.put(entry.getKey(), entry.getValue());
//        }
        return metadata;
    }

}