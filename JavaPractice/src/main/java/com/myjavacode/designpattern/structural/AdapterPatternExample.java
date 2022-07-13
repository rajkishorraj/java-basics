package com.myjavacode.designpattern.structural;


public class AdapterPatternExample {
    public static void main(String[] args) {
        SquareBar squareBar = new SquareBar();
        SquareAdapter squareAdapter = new SquareAdapter(squareBar);

    }
}

interface RoundBar {
    int getDiameter();
}

class SmallRoundBar implements RoundBar {

    @Override
    public int getDiameter() {
        return 0;
    }
}

class SquareBar {
    int getLength() {
        return 0;
    }
}

class SquareAdapter implements RoundBar {

    private SquareBar squareBar;

    SquareAdapter(SquareBar squareBar) {
        this.squareBar = squareBar;
    }

    @Override
    public int getDiameter() {
        return 0;
    }
}



