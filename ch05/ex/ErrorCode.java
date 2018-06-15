package ch05.ex;

// 5-1
// Write a method public ArrayList<Double> readValues(String filename)
// throws ... that reads a file containing floating-point
// numbers. Throw appropriate exceptions if the file could not be
// opened or if some of the inputs are not floating-point numbers.

// 5-2
// Write a method public double sumOfValues(String filename) throws
// ... that calls the preceding method and returns the sum of the
// values in the file. Propagate any exceptions to the caller.

// 5-4 TODO
// Repeat the preceding exercise, but don't use exceptions. Instead,
// have readValues and sumOfValues return error codes of some kind.

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFloatPoint {

    public static ArrayList<Double> readValues(String filename) throws IOException, NumberFormatException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            ArrayList<Double> alist = new ArrayList<Double>();
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                alist.add(Double.valueOf(tempStr));
            }
            reader.close();
            return alist;
        }
    }

    public static double sumOfValues(String filename) throws IOException, NumberFormatException{
        ArrayList<Double> alist;
        alist = readValues(filename);
        double sum = 0;
        for (double d : alist) {
            sum += d;
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Double> alist;
            alist = readValues("floating.txt");
            System.out.println(alist);
            System.out.printf("SUM: %f\n", sumOfValues("floating.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
