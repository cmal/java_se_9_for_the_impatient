package ch05.ex;

// Write a method public ArrayList<Double> readValues(String filename)
// throws ... that reads a file containing floating-point
// numbers. Throw appropriate exceptions if the file could not be
// opened or if some of the inputs are not floating-point numbers.

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFloatPoint {

    public static ArrayList<Double> readValues(String filename) throws IOException, NumberFormatException{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            ArrayList<Double> alist = new ArrayList<Double>();
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                alist.add(Double.valueOf(tempStr));
            }
            reader.close();
            return alist;
    }
p
    public static void main(String[] args) {
        try {
            ArrayList<Double> alist;
            alist = readValues("floating.txt");
            System.out.println(alist);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
