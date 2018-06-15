package ch05.ex;

// 6. Section 5.1.6, “The finally Clause” (page 189) has an example
// of a broken try statement with catch and finally clauses. Fix the
// code with (a) catching the exception in the finally clause, (b) a
// try/catch statement containing a try/finally statement, and (c) a
// try-with-resources statement with a catch clause.

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.IOException;


public class FinallyClause {

    public static void fixedFinally1 (Path path) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            // Read from in
            String inStr;
            while ((inStr = in.readLine()) != null) {
                System.out.println(inStr);
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            // The broken version:
            // if (in != null) {
            //     in.close(); // Caution—might throw an exception
            // }

            // fix (a)
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fixedFinally2 (Path path) {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                // Read from in
                String inStr;
                while ((inStr = in.readLine()) != null) {
                    System.out.println(inStr);
                }
            } catch (IOException ex) {
                System.err.println("Caught IOException: " + ex.getMessage());
            } finally {
                // The broken version:
                // if (in != null) {
                //     in.close(); // Caution—might throw an exception
                // }

                // fix (a)
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fixedFinally3 (Path path) {
        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            // Read from in
            String inStr;
            while ((inStr = in.readLine()) != null) {
                System.out.println(inStr);
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        Path path = Paths.get("finally.txt");
        fixedFinally1(path);
        fixedFinally2(path);
        fixedFinally3(path);
    }
}
