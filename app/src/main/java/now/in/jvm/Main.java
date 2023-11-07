package now.in.jvm;

import java.io.*;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main implements Runnable {
    
    @Override
    public void run() {
        Queue<Integer> queue = new PriorityQueue<>(3);
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("22021201.txt");
            if (url == null) {
                System.out.println("url is null");
                return;
            }
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
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
