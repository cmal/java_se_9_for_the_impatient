package ch09.ex;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BufferedReaderVsScanner {

    public static int readUsingScanner(Path in) throws IOException{
        Scanner inS = new Scanner(in);
        int counter = 0;
        while(inS.hasNextLine()) {
            inS.nextLine();
            counter ++;
        }
        return counter;
    }

    public static int readUsingBufferedReader(Path in) throws IOException{
        BufferedReader br = Files.newBufferedReader(in);
        int counter = 0;
        while(br.readLine() != null) {
            counter ++;
        }
        return counter;
    }

    public static long readUsingBufferedReaderLines(Path in) throws IOException{
        BufferedReader br = Files.newBufferedReader(in);
        return br.lines().count();
    }
    
    public static void main(String[] args) {
        Path in = Paths.get("/usr/share/dict/words");

        try {
        var startTime = System.currentTimeMillis();
        int a = readUsingScanner(in);
        var midTime1 = System.currentTimeMillis();
        int b = readUsingBufferedReader(in);
        var midTime2 = System.currentTimeMillis();
        long c = readUsingBufferedReaderLines(in);
        var endTime = System.currentTimeMillis();
        System.out.printf("%d, %d, %d\n", a, b, c);
        System.out.printf("Time a: %dms, b: %dms, c: %dms\n",
                           midTime1 - startTime,
                           midTime2 - midTime1,
                           endTime - midTime2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
