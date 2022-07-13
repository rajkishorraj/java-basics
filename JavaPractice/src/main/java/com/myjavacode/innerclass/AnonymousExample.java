package com.myjavacode.innerclass;


public class AnonymousExample {
    Food food = new Food() {
        public String popCorn() {
            return "popcorn food";
        }
    };

//    AnonymouseExample2 anonymouseExample2 = new AnonymouseExample2() {
//        public String running() {
//            return "its running";
//        }
//    };

    AnonymouseExample2 anonymouseExample2 = () -> "its running";

    public String getFood() {
        return food.popCorn();
    }


     public static void main(String[] args) {
         AnonymousExample anonymouseExample = new AnonymousExample();

        System.out.println(new AnonymousExample().getFood() + " " + anonymouseExample.anonymouseExample2);

    }
}

class Food {

    public String popCorn() {
        return "popcorn";
    }
}