package com.myjavacode.coll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListColl3 {


    public static void main(String [] args) {
        method();
    }

    public static void method() {
        try {
            try {
                int x = 5/ 0;
            } finally {
                System.out.println("iner finally");
            }
        } finally {
            System.out.println("outer finally");
        }
    }

}




@Getter
@RequiredArgsConstructor
class Sample extends ListColl3 {

    private String a;
    private final int b;

}

