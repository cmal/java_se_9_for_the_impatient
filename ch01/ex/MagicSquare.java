package ch01.ex;

import java.lang.Integer;
import java.util.Scanner;
import java.util.ArrayList;

public class MagicSquare {
    public static void main(String[] args) {
        System.out.println("Give me a magic square:");
        Scanner in = new Scanner(System.in);
        int rows = 0, cols = 0, tmpCols;
        ArrayList<ArrayList<Integer>> numArr = new ArrayList<ArrayList<Integer>>();
        for (;;) {
            String inStr = in.nextLine();
            if (inStr.length() == 0) {
                if (rows != cols) {
                    System.out.println("Plz give me a SQUARE! <Rows != Cols>");
                    return;
                }
                break;
            }
            String[] inStrArr = inStr.split("\\s+");
            tmpCols = inStrArr.length;
            if (rows == 0) {
                cols = tmpCols;
            } else if (cols != tmpCols) {
                System.out.printf("Row %d has %d cols, but row %d has %d cols!",
                                  rows, tmpCols, rows - 1, cols);
                return;
            }
            cols = tmpCols;
            // into numArr
            ArrayList<Integer> rowArr = new ArrayList<Integer>();
            for (String el : inStrArr) {
                rowArr.add(Integer.parseInt(el));
            }
            numArr.add(rowArr);
            rows ++;
        }

        int sum = 0, tmpSum = 0;
        // Calc diagonals sums
        for (int i = 0; i < rows; i ++) {
            tmpSum += numArr.get(i).get(i);
        }
        sum = tmpSum;
        tmpSum = 0;
        for (int i = 0; i < rows; i ++) {
            tmpSum += numArr.get(i).get(rows - i - 1);
        }
        if (sum != tmpSum) {
            System.out.println("Sum not match.<Diagnal>");
            return;
        }
        tmpSum = 0;
        // Calc row sums
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                tmpSum += numArr.get(i).get(j);
            }
            if (sum != tmpSum) {
                System.out.println("Sum not match.<Row>");
                return;
            }
            tmpSum = 0;
        }
        // Calc col sums
        for (int j = 0; j < cols; j ++) {
            for (int i = 0; i < rows; i ++) {
                tmpSum += numArr.get(i).get(j);
            }
            if (sum != tmpSum) {
                System.out.println("Sum not match.<Col>");
                return;
            }
            tmpSum = 0;
        }
        
        System.out.println("Congratulations: you've got a MAGIC SQUARE!");
    }
}
