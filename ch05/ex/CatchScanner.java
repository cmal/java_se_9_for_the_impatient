package ch05.ex;

// Implement a method that contains the code with a Scanner and a
// PrintWriter in Section 5.1.5.  Don't use the try-with-resources
// statement. Instead, just use catch clauses. Be sure to close both
// objects, provided they have been properly constructed. You need to
// consider the following conditions:

// • The Scanner constructor throws an exception.
// • The PrintWriter constructor throws an exception.
// • hasNext, next, or println throw an exception.
// • out.close() throws an exception.
// • in.close() throws an exception.

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;


public class CatchScanner {
    public static void catchScanner () {
        try{
            Scanner in = new Scanner(System.in);
            ArrayList<String> lines = new ArrayList<String> ();
            for (;;) {
                if (inStr.hasNextLine()) {
                    String inStr = in.nextLine();
                    lines.add(inStr);
                }
            }
            in.close();
            PrintWriter out = new PrintWriter("output.txt");
            for (String line : lines) {
                out.println(line.toLowerCase());
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        catchScanner();
    }
}
