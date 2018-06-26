package ch10.ex;

import java.util.*;
import java.util.stream.Stream;
import java.nio.file.*;
import java.io.*;

public class FindFile {

//     “Using parallel streams, find all files in a directory that
//     contain a given word. How do you find just the first one?

//    Are the files actually searched concurrently? TODO


    public static void main(String[] args) {
        try {
        Path path = Paths.get(".");
        Stream<Path> sp = Files.walk(path);
        sp.parallel()
             // keep away from MalformedInputException
            .filter(p -> p.toString().endsWith(".java"))
            .filter(p -> {
                if (Files.isRegularFile(p) && Files.isReadable(p)) {
                    try(Stream<String> s = Files.lines(p)) {
                        // System.out.println(p);
                        return s.anyMatch(line -> line.contains("parallel"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }).forEach(System.out::println);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
