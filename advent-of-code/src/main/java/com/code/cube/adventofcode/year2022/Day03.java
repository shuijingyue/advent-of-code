package com.code.cube.adventofcode.year2022;


import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

public class Day03 implements Day {
    int sum = 0;
    int idx = 0;
    
    @Override
    public void printResult() {
        printPart1Result();
        printPart2Result();
    }
    
    private void printPart1Result() {
        InputHelper.readline(2022, 3, line -> {
            int len = line.length() / 2;
            boolean[] recordL = new boolean[53];
            boolean[] recordR = new boolean[53];
            for (int i = 0; i < len; i++) {
                char letterL = line.charAt(i);
                int point = getPointOfLetter(letterL);
                if (recordR[point]) {
                    sum += point;
                    break;
                }
                recordL[point] = true;
                char letterR = line.charAt(len + i);
                point = getPointOfLetter(letterR);
                if (recordL[point]) {
                    sum += point;
                    break;
                }
                recordR[point] = true;
            }
        });
        System.out.println(sum);
    }
    
    private void printPart2Result() {
        sum = 0;
        String[] lines = new String[3];
        InputHelper.readline(2022, 3, line -> {
            lines[idx++] = line;
            if (idx == 3) {
                idx = 0;
                boolean[][] records = new boolean[3][];
                out:
                for (int i = 0; i < records.length; i++) {
                    int len = lines[i].length();
                    records[i] = new boolean[53];
                    for (int j = 0; j < len; j++) {
                        int p = getPointOfLetter(lines[i].charAt(j));
                        if (i < 2) {
                            records[i][p] = true;
                        } else if (records[0][p] && records[1][p]) {
                            sum += p;
                            break out;
                        }
                    }
                }
            }
        });
        System.out.println(sum);
    }
    
    private int getPointOfLetter(char letter) {
        return Character.isUpperCase(letter) ? letter - 38 : letter - 96;
    }
}