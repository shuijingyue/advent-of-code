package com.code.sjy.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.Queue;

class Day20221201 implements Day {
    
    @Override
    public void printResult() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("202201.txt");
            assert url != null;
            BufferedReader reader = new BufferedReader(new FileReader(url.getFile()));
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    queue.add(sum);
                    if (queue.size() > 3) {
                        queue.poll();
                    }
                    sum = 0;
                } else {
                    sum += Integer.parseInt(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int sum = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            sum += num;
            max = Math.max(max, num);
        }
        System.out.printf("part1: %d, part2: %d\n", max, sum);
    }
}