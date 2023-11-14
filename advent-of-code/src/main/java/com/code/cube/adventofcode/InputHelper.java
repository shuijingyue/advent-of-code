package com.code.cube.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

public class InputHelper {
    public static void readline(int year, int day, Consumer<String> callback) {
        String filename = filename(year, day);
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
            if (url == null) {
                System.out.println("url is null, filename = " + filename);
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(url.getFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                callback.accept(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String readText(int year, int day) {
        StringBuilder sb = new StringBuilder();
        readline(year, day, sb::append);
        return sb.toString();
    }
    
    private static final String INPUT_FILE_SUFFIX = ".txt";
    
    private static String filename(int year, int day) {
        return year + "/" + (day < 10 ? "0" + day : day) + INPUT_FILE_SUFFIX;
    }
}