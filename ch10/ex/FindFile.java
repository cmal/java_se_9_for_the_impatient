package ch10.ex;

import java.util.*;
import java.nio.file.*;

public class FindFile {

    public static void main(String[] args) {
        
        Stream<Path> sp = Files.walk(".");
        sp.parallel().forEach(p -> {
                if (Files.isRegularFile(p) && Files.isReadable(p)) {
                    System.out.println('can read file');
                    
                }
            });
        
    }
}
