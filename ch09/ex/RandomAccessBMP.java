package ch09.ex;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class RandomAccessBMP {

    private RandomAccessFile file;
    private ArrayList<ArrayList<Integer>> stack;

    RandomAccessBMP(String filename) {
        file = new RandomAccessFile(filename);
        stack = new ArrayList<>();
    }

    public void reflect() {
        // A special sequence of 00h 00h represents the end of a row.
        
    }
    
    public static void main(String[] args) {
        var bmp = new RandomAccessBMP("python1.bmp");
        bmp.reflect();
    }
}
