package com.code.cube.adventofcode.year2022;

import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

import java.util.Arrays;


public class Day06 implements Day {
    @Override
    public void printResult() {
        String inputString = InputHelper.readText(2022, 6);
        int result1 = indexOfUnqiueLetters(inputString, 4, 0) + 1;
        System.out.println(result1);
        System.out.println(indexOfUnqiueLetters(inputString, 14, 0) + 1);
    }
    
    private int indexOfUnqiueLetters(String inputString, int count, int start) {
        int len = inputString.length();
        int j = 0;
        int[] indexes = new int[26];
        Arrays.fill(indexes, -1);
        for (int i = start; i < len; i++) {
            int idx = inputString.charAt(i) - 'a';
            if (indexes[idx] == -1 && i - j + 1 == count) {
                return i;
            }
            int tmpIdx = indexes[idx];
            if (tmpIdx != -1) {
                for (int k = j; k <= tmpIdx; k++) {
                    indexes[inputString.charAt(k) - 'a'] = -1;
                }
                j = tmpIdx + 1;
            }
            indexes[idx] = i;
        }
        return -1;
    }
}