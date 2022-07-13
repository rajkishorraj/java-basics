package com.myjavacode.immutableclass;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableExample2 {

    public static void main(String[] args) {


        String ss = "dssf";

        ss.toUpperCase(); //immutablitly mean once you created the object you can not modify that object
        //however you can change the refrence variable to refer to some other object
        //if you do try to modify the object a new object will be created but that object will not get moidifed

        System.out.println(ss + " ");

        final Map<String, String> mp =  new HashMap<>();

        System.out.println(mp);

        mp.put("ss", "st"); //we can not refer final variable to something else but we can modify the object

        System.out.println(mp);
        //        mp = new HashMap<>(); //can not assign another object or value


        final Map<String, String> unmodifiableMap = Collections.unmodifiableMap(mp);

        System.out.println("unmodifiableMap: " + unmodifiableMap);

        unmodifiableMap.put("ss", "st"); //no we can not modify the object other
        //final simply makes the object reference unchangeable. The object it points to is not immutable
        // by doing this. INSTANCE can never refer to another object, but the object it refers to may change state.
        //when field is final is guaranteed to be visible in other threads immediately after constructor is finished.

        System.out.println("unmodifiableMap: " + unmodifiableMap);


        final Integer x = 6;
//        x =  x + 5;// give error because final value can't be reassinged once initilaize
        //but just Integer x = 6 // is immutable it can refer to new value or object

        final String xx = "sfs";
//        xx = "sfs"; //can not reassinged
    }
}
