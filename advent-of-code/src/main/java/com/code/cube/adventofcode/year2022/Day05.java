package com.code.cube.adventofcode.year2022;

import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

import java.util.Arrays;
import java.util.Stack;

public class Day05 implements Day {
    int lineNum = 1;
    static final int STACK_COUNT = 9;
    static final int LAST_STACK_LINE_NUM = 8;
    static final int MOVE_START_LNNE_NUM = 11;
    
    @Override
    public void printResult() {
        printResult1();
        printResult2();
    }
    
    private void printResult1() {
        Stack<Character>[] stacks = new Stack[STACK_COUNT];
        for (int i = 0; i < STACK_COUNT; i++) {
            stacks[i] = new Stack<>();
        }
        String[] lines = new String[LAST_STACK_LINE_NUM];
        InputHelper.readline(2022, 5, line -> {
            if (lineNum <= LAST_STACK_LINE_NUM) {
                lines[lineNum - 1] = line;
                if (lineNum == LAST_STACK_LINE_NUM) {
                    for (int i = 7; i > -1; i--) {
                        for (int j = 0;  j < 9; j++) {
                            char c = lines[i].charAt(j * 4 + 1);
                            if (c != ' ') {
                                stacks[j].push(c);
                            }
                        }
                    }
                }
            } else if (lineNum == MOVE_START_LNNE_NUM - 1) {
                System.out.println(Arrays.toString(stacks));
            } else if (lineNum >= MOVE_START_LNNE_NUM) {
                String[] operators = line.split(" ");
                int count = Integer.parseInt(operators[1]);
                int from = Integer.parseInt(operators[3]) - 1;
                int to = Integer.parseInt(operators[5]) - 1;
                for (int i = 0; i < count; i++) {
                    stacks[to].push(stacks[from].pop());
                }
            }
            lineNum++;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < STACK_COUNT; i++) {
            if (!stacks[i].isEmpty()) {
                sb.append(stacks[i].peek());
            }
        }
        System.out.println(sb);
    }
    
    private void printResult2() {
        lineNum = 1;
        Stack<Character>[] stacks = new Stack[STACK_COUNT];
        for (int i = 0; i < STACK_COUNT; i++) {
            stacks[i] = new Stack<>();
        }
        String[] lines = new String[LAST_STACK_LINE_NUM];
        InputHelper.readline(2022, 5, line -> {
            if (lineNum <= LAST_STACK_LINE_NUM) {
                lines[lineNum - 1] = line;
                if (lineNum == LAST_STACK_LINE_NUM) {
                    for (int i = 7; i > -1; i--) {
                        for (int j = 0;  j < 9; j++) {
                            char c = lines[i].charAt(j * 4 + 1);
                            if (c != ' ') {
                                stacks[j].push(c);
                            }
                        }
                    }
                }
            } else if (lineNum == MOVE_START_LNNE_NUM - 1) {
                System.out.println(Arrays.toString(stacks));
            } else if (lineNum >= MOVE_START_LNNE_NUM) {
                String[] operators = line.split(" ");
                int count = Integer.parseInt(operators[1]);
                int from = Integer.parseInt(operators[3]) - 1;
                int to = Integer.parseInt(operators[5]) - 1;
                Stack<Character> stack = new Stack<>();
                
                for (int i = 0; i < count; i++) {
                    stack.push(stacks[from].pop());
                }
                
                while (!stack.isEmpty()) {
                    stacks[to].push(stack.pop());
                }
            }
            lineNum++;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < STACK_COUNT; i++) {
            if (!stacks[i].isEmpty()) {
                sb.append(stacks[i].peek());
            }
        }
        System.out.println(sb);
    }
}