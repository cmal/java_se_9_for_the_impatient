package ch08.ex;

import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class Parallel {
    public static void main(String[] args) {
        try {

            String contents = new String(Files.readAllBytes(Paths.get("words.txt")),
                                         StandardCharsets.UTF_8);
            List<String> words = List.of(contents.split("\n"));
            long startTime = System.currentTimeMillis();
            long count1 = words.stream().filter(w -> {
                    // System.out.printf("Fetching %s\n", w);
                    return w.length() > 5;
                }).count();
            // System.out.println("----");
            // System.out.println(count);
            long midTime = System.currentTimeMillis();
            long count2 = words.stream().filter(w -> {
                    // System.out.printf("Fetching %s\n", w);
                    return w.length() > 5;
                }).count();
            // System.out.println("----");
            // System.out.println(count);
            long endTime = System.currentTimeMillis();
            System.out.printf("%dms, %dms\n", midTime - startTime, endTime - midTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
