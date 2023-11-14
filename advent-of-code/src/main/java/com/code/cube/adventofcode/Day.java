package com.code.cube.adventofcode;

public interface Day {
    void printResult();

    static Day newInstance(int year, int day) {
        try {
            Class<Day> dayClass = (Class<Day>) Class.forName(dayClassName(year, day));
            return dayClass.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    String DAY_PACKAGE_NAME = "com.code.cube.adventofcode";
    
    static String dayClassName(int year, int day) {
        String dayString = day < 10 ? "0" + day : day + "";
        return String.format("%s.year%d.Day%s", DAY_PACKAGE_NAME, year, dayString);
    }
}