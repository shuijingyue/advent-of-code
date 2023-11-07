package com.code.sjy.adventofcode;

public class Main implements Runnable {
    
    @Override
    public void run() {
        Day day = new Day20221201();
        day.printResult();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
