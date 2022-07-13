package com.myjavacode.designpattern.structural;

public class BridePatternExample {
}

abstract class Shape {
    Coloring coloring;

    Shape (Coloring coloring) {
       this.coloring = coloring;
    }

    abstract void create();
}

interface Coloring {
    void paint();
}

class Red implements Coloring {

    @Override
    public void paint() {
        
    }
}

class Green implements Coloring {

    @Override
    public void paint() {

    }
}

class Square extends Shape {

    Square(Coloring coloring) {
        super(coloring);
    }

    @Override
    public void create() {
        coloring.paint();
    }
}

class Rectangle extends Shape {

    Rectangle(Coloring coloring) {
        super(coloring);
    }

    @Override
    public void create() {
        coloring.paint();
    }
}