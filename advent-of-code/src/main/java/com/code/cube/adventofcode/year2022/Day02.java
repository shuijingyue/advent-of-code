package com.code.cube.adventofcode.year2022;

import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

import java.util.HashMap;
import java.util.Map;

public class Day02 implements Day {
    // X    Y     Z
    // A    B     C
    // CX AY BZ
    // AX BY CZ
    // BX CY AZ
    // rock paper scissors
    private static final Map<String, Integer> points = new HashMap<>();

    private static final char[] wonMap   = new char[]{'Y', 'Z', 'X'};
    private static final char[] lostMap  = new char[]{'Z', 'X', 'Y'};
    private static final char[] drawMap  = new char[]{'X', 'Y', 'Z'};
    private static final int[] strategyPoints = new int[]{1, 2, 3};
    private static final int[] resultPoints = new int[]{0, 3, 6};
    private static final char[][] strategyMaps = new char[][]{lostMap, drawMap, wonMap};

    int part1Sum = 0;
    int part2Sum = 0;
    static {
        points.put("AX", 4);
        points.put("AY", 8);
        points.put("AZ", 3);
        points.put("BX", 1);
        points.put("BY", 5);
        points.put("BZ", 9);
        points.put("CX", 7);
        points.put("CY", 2);
        points.put("CZ", 6);
    }
    
    @Override
    public void printResult() {
        InputHelper.readline(2022, 2, line -> {
            char c1 = line.charAt(0);
            char c2 = line.charAt(2);
            part1Sum += points.getOrDefault("" + c1 + c2, 0);
            char[] strategyMap = strategyMaps[c2 - 'X'];
            part2Sum += resultPoints[c2 - 'X'];
            part2Sum += strategyPoints[strategyMap[c1 - 'A'] - 'X'];
        });
        System.out.println(part1Sum);
        System.out.println(part2Sum);
    }
}