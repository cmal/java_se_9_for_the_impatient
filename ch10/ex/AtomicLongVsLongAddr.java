package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class AtomicLongVsLongAddr {

    // 9. Generate 1,000 threads, each of which increments a counter
    // 100,000 times. Compare the performance of using AtomicLong
    // versus LongAdder.

    AtomicLong al = new AtomicLong(0);
    LongAdder la = new LongAdder();
    
    public class AtomicLongThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i ++) {
                al.incrementAndGet();
            }
        }
    }

    public class LongAdderThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i ++) {
                la.increment();
            }
        }
    }

    public static void main(String[] args) {
        AtomicLongVsLongAddr vs = new AtomicLongVsLongAddr();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i ++) {
            (vs.new AtomicLongThread()).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("AtomicLong--Number: %s, Time: %d\n", vs.al, endTime - startTime);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i ++) {
            (vs.new LongAdderThread()).start();
        }
        long res = vs.la.sum();
        endTime = System.currentTimeMillis();
        System.out.printf("LongAdder--Number: %s, Time: %d\n", res, endTime - startTime);
        
    }

}
