package com.code.cube.adventofcode.year2022;

import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

public class Day04 implements Day {
    int sum1 = 0;
    int sum2 = 0;
    @Override
    public void printResult() {
        InputHelper.readline(2022, 4, line -> {
            String[] parts = line.split(",");
            String[] pair1 = parts[0].split("-");
            String[] pair2 = parts[1].split("-");
            int x0 = Integer.parseInt(pair1[0]),
                y0 = Integer.parseInt(pair1[1]),
                x1 = Integer.parseInt(pair2[0]),
                y1 = Integer.parseInt(pair2[1]);
            if (contains(x0, y0, x1, y1) || contains(x1, y1, x0, y0)) {
                sum1++;
            }
            if (overlaps(x0, y0, x1, y1) || contains(x1, y1, x0, y0)) {
                sum2++;
            }
        });
        System.out.println(sum1);
        System.out.println(sum2);
    }
    
    private boolean contains(int x0, int y0, int x1, int y1) {
        return x0 <= x1 && y0 >= y1;
    }
    
    private boolean overlaps(int x0, int y0, int x1, int y1) {
        return x1 >= x0 && x1 <= y0 || y1 >= x0 && y1 <= y0;
    }
}