package com.code.cube.adventofcode.year2022;

import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

import java.util.PriorityQueue;
import java.util.Queue;

public class Day01 implements Day {
    int sum = 0;
    @Override
    public void printResult() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        InputHelper.readline(2022, 1, line -> {
            if (line.isBlank()) {
                queue.add(sum);
                if (queue.size() > 3) {
                    queue.poll();
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }    
        });
        sum = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            sum += num;
            max = Math.max(max, num);
        }
        System.out.println(max);
        System.out.println(sum);
    }
}