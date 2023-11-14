package com.code.cube.adventofcode;

public class Main implements Runnable {

    @Override
    public void run() {
        Day day = Day.newInstance(2022, 6);
        day.printResult();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
