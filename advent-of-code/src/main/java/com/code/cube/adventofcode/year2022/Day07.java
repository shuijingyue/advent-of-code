package com.code.cube.adventofcode.year2022;

import com.code.cube.adventofcode.Day;
import com.code.cube.adventofcode.InputHelper;

import java.util.ArrayList;

public class Day07 implements Day {
    long sum1 = 0;
    long sum2 = Long.MAX_VALUE;
    static final long MEMORY_TOTAL = 70000000;
    static final long MEMORY_NEED = 30000000;

    @Override
    public void printResult() {
        FileSystem fs = new FileSystem();
        InputHelper.readline(2022, 7, fs::parse);

        calculateSize(fs.root);

        long memorySize = fs.root.size + MEMORY_NEED - MEMORY_TOTAL;
        freeMemoryToUpdate(fs.root, memorySize);

        System.out.println(sum1);
        System.out.println(sum2);
    }

    long calculateSize(FileNode fileNode) {
        for (FileNode node : fileNode.children) {
            fileNode.size += node.isFile() ? node.size : calculateSize(node);
        }
        if (fileNode.size < 100000) {
            sum1 += fileNode.size;
        }
        return fileNode.size;
    }

    void freeMemoryToUpdate(FileNode node, long memorySize) {
        if (node.size > memorySize) {
            sum2 = Math.min(node.size, sum2);
        }
        for (FileNode child : node.children) {
            if (child.isDir()) {
                freeMemoryToUpdate(child, memorySize);
            }
        }
    }

    static final int TYPE_FILE = 1;
    static final int TYPE_DIR = 2;

    static final String COMMAND_CD = "cd";
    static final String COMMAND_LS = "ls";

    class FileNode {
        String name;
        int type;
        long size;
        FileNode parent;
        ArrayList<FileNode> children;
        FileNode(String name, int type) {
            this.name = name;
            this.type = type;
            this.children = new ArrayList<>();
        }
        FileNode(String name, int type, long size) {
            this(name, type);
            this.size = size;
        }
        void addNode(FileNode fileNode) {
            fileNode.parent = this;
            children.add(fileNode);
        }
        boolean isDir() {
            return type == TYPE_DIR;
        }

        boolean isFile() {
            return type == TYPE_FILE;
        }
    }

    class FileSystem {
        FileNode cwd;
        FileNode root;
        void parse(String line) {
            if (line.startsWith("$")) {
                parseCommand(line);
            } else {
                parseFile(line);
            };
        }

        void parseCommand(String line) {
            String[] parts = line.split(" ");
            if (parts[1].equals(COMMAND_CD)) {
                executeCd(parts[2]);
            }
        }

        void executeCd(String dirname) {
            if (dirname.equals("/")) {
                cwd = new FileNode(dirname, TYPE_DIR);
                root = cwd;
            } else if (dirname.equals("..")) {
                cwd = cwd.parent;
            } else {
                ArrayList<FileNode> children = cwd.children;
                if (children != null) {
                    for (FileNode node : children) {
                        if (node.isDir() && node.name.equals(dirname)) {
                            cwd = node;
                            break;
                        }
                    }
                } else {
                    System.out.println("error when execute cd " + dirname);
                }
            }
        }

        void parseFile(String line) {
            String[] parts = line.split(" ");
            int type = "dir".equals(parts[0]) ? TYPE_DIR : TYPE_FILE;
            long size = "dir".equals(parts[0]) ? 0 : Long.parseLong(parts[0]);
            cwd.addNode(new FileNode(parts[1], type, size));
        }
    }
}