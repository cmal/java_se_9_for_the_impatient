package ch01.ex;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Generate Pascal Triangle of level: ");
        int n = in.nextInt();

        ArrayList<ArrayList<Integer>> rowArray = new ArrayList<ArrayList<Integer>>();
        for (int row = 0; row < n; row ++) {
            ArrayList<Integer> colArray = new ArrayList<Integer>();
            for (int col = 0; col <= row; col ++) {
                if (col == 0 || col == row) {
                    colArray.add(1);
                } else {
                    colArray.add(rowArray.get(row - 1).get(col - 1) + rowArray.get(row - 1).get(col));
                }
            }
            rowArray.add(colArray);
        }
        System.out.println(rowArray);
    }
}
