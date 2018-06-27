package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

public class LongAccumulatorMax {

    // 10. Use a LongAccumulator to compute the maximum or minimum of
    // the accumulated elements.

    public static void main(String[] args) {

        int numberOfThreads = 2;
        int numberOfIncrements = 100;

        LongAccumulator accMax = new LongAccumulator(Math::max, 0);
        LongAccumulator accMin = new LongAccumulator(Math::min, 0);
        
        Runnable maxAction = () -> IntStream
            .rangeClosed(0, numberOfIncrements)
            .forEach(accMax::accumulate);

        Runnable minAction = () -> IntStream
            .rangeClosed(0, numberOfIncrements)
            .forEach(accMin::accumulate);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(maxAction);
        executor.execute(minAction);

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Max: %d\nMin: %d\n", accMax.get(), accMin.get());
    }

    
}
