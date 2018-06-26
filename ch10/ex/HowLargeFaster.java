package ch10.ex;

import java.util.*;
import java.io.*;
import java.nio.file.*;

// 2. How large does an array have to be for Arrays.parallelSort to
// be faster than Arrays.sort on your computer?

public class HowLargeFaster {

    public static long sortTime(int[] arr) {
        long startTime = System.currentTimeMillis();
        Arrays.sort(arr);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long parallelSortTime(int[] arr) {
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(arr);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void shuffle(int[] arr) {
        // Fisher–Yates shuffle
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--)
            {
                int index = random.nextInt(i + 1);
                if (index != i)
                    {
                        arr[index] ^= arr[i];
                        arr[i] ^= arr[index];
                        arr[index] ^= arr[i];
                    }
            }
    }

    public static boolean compareSorts(int limit) {
        int[] arr = new int[limit];
        for (int i = 0; i < limit; i ++) {
            arr[i] = i;
        }
        
        shuffle(arr);
        int[] arr1 = Arrays.copyOf(arr, limit);

        // false when faster
        return parallelSortTime(arr) - sortTime(arr1) > 0;
        
    }
    
    public static void main(String[] args) {
        int i = 10000;
        while (compareSorts(i)) {
            i += 1000;
        }
        System.out.println(i);
    }
}
