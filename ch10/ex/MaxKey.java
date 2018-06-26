package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class MaxKey {
    // 8. In a ConcurrentHashMap<String, Long>, find the key with
    // maximum value (breaking ties arbitrarily). Hint: reduceEntries.

    public ConcurrentHashMap<String, Long> chm;

    MaxKey() {
        chm = new ConcurrentHashMap<>();
    }

    public String findMax() {
        Map.Entry<String, Long> entry = chm.reduceEntries(10, (e1, e2) -> {
                return e1.getValue() > e2.getValue() ? e1 : e2;
            });
        return entry.getKey();
    }

    public static void main(String[] args) {
        MaxKey mk = new MaxKey();
        for (int i = 0; i < 100000; i ++) {
            mk.chm.put(i + ":", (long)i);
        }
        
        System.out.println(mk.findMax());
    }
    
}


