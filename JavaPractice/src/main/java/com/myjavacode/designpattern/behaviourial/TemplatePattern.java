package com.myjavacode.designpattern.behaviourial;

public class TemplatePattern {

    public static void main(String[] args) {
        Game game = new Chess();
        game.play();
    }
}

abstract class Game {
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play() {
        initialize();
        start();
        end();
    }
}

class Chess extends Game {

    @Override
    void initialize() {

    }

    @Override
    void start() {

    }

    @Override
    void end() {

    }
}