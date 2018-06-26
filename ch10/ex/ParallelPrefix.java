package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ParallelPrefix {
// 4. One parallel operation not discussed in Section 10.4.2,
// “Parallel Array Operations” (page 349) is the parallelPrefix
// method that replaces each array element with the accumulation of
// the prefix for a given associative operation. Huh? Here is an
// example. Consider the array [1, 2, 3, 4, ...] and the ×
// operation. After executing Arrays.parallelPrefix(values, (x, y) ->
// x * y), the array contains
// [1, 1 × 2, 1 × 2 × 3, 1 × 2 × 3 × 4, ...]
// Perhaps surprisingly, this computation can be parallelized. First,
// join neighboring elements, as indicated here:
// [1, 1 × 2, 3, 3 × 4, 5, 5 × 6, 7, 7 × 8]
// The gray values are left alone. Clearly, one can make this
// computation concurrently in separate regions of the array. In the
// next step, update the indicated elements by multiplying them with
// elements that are one or two positions below:
// [1, 1 × 2, 1 × 2 × 3, 1 × 2 × 3 × 4, 5, 5 × 6, 5 × 6 × 7,
// 5 × 6 × 7 × 8]
// This can again be done concurrently. After log(n) steps, the
//       process is complete. This is a win over the straightforward
//       linear computation if sufficient processors are available.
//       In this exercise, you will use the parallelPrefix method to
//       parallelize the computation of Fibonacci numbers. We use the
//       fact that the nth Fibonacci number is the top left
//       coefficient of Fn, where F=(1 1 / 1 0) . Make an array filled
//       with 2 × 2 matrices. Define a Matrix class with a
//       multiplication method, use parallelSetAll to make an array of
//       matrices, and use parallelPrefix to multiply them.


    public static class Matrix {

        public int a, b, c, d;

        Matrix(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public Matrix multiplication(Matrix m) {
            return new Matrix(a * m.a + b * m.c,
                              a * m.b + b * m.d,
                              c * m.a + d * m.c,
                              c * m.b + d * m.d);
        }

        public String toString() {
            return "{" + a + "\t" + b + "\n " + c + "\t" + d + "}";
        }
    }
    
    public static void main(String[] args) {
        int limit = 10;
        int[] arr = new int[limit];
        for (int i = 0; i < limit; i ++) {
            arr[i] = i + 1;
        }

        Arrays.parallelPrefix(arr, (x, y) -> x * y);

        for (int i = 0; i < limit; i ++) {
            System.out.println(arr[i]);
        }

        Matrix m = new Matrix(1, 1, 1, 0);

        int mLimit = 50;
        Matrix[] mArr = new Matrix[mLimit];
        for (int i = 0; i < mLimit; i ++) {
            mArr[i] = m;
        }
        Arrays.parallelPrefix(mArr, (x, y) -> x.multiplication(y));
        for (int i = 0; i < mLimit; i ++) {
            System.out.println(mArr[i].a);
        }
    }
    
}
