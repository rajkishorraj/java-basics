package com.myjavacode.generics;

import java.util.ArrayList;
import java.util.List;

public class Cricket implements Player {
    @Override
    public void practice() {
        System.out.println("practicing bowling");
    }

    static void checkPlayer(List<? extends Player> players) {

        for ( Player player : players) {
            player.practice();
        }
    }

    public static void main(String [] args) {
        List<Cricket> crickets = new ArrayList<>();
        crickets.add(new Cricket());
        List<Football> footballs = new ArrayList<>();
        footballs.add(new Football());
        checkPlayer(crickets);
        checkPlayer(footballs);
    }
}

class Football implements Player {

    @Override
    public void practice() {
        System.out.println("practicing running");
    }
}
