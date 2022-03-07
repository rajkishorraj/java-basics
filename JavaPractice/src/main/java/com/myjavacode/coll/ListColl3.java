package com.myjavacode.coll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ListColl3 {


    public static void main(String [] args) {

//        List<String> arraylist = new ArrayList<>();
//        Integer i1 = 100;
//        Integer i2 = 100;
//        System.out.println(i1 != i2);
//        Sample sample = new Sample("sfs", 6);
        Sample sample = new Sample(6);
        System.out.println(sample.getB());
    }
}

@Getter
@RequiredArgsConstructor
class Sample extends ListColl3 {

    private String a;
    private final int b;

}
