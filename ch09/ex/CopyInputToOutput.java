package ch09.ex;

import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class CopyInputToOutput {

    public static void directCopy(InputStream in,
                                  OutputStream out) {
        try {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void indirectCopy(InputStream in,
                                    OutputStream out) {
        try {
            Path tmp = Files.createTempFile("javaio",
                                            ".tmp");
            OutputStream tmpFileOut = Files.newOutputStream(tmp);
            InputStream tmpFileIn = Files.newInputStream(tmp);
            in.transferTo(tmpFileOut);
            tmpFileIn.transferTo(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // directCopy(System.in, System.out);
        indirectCopy(System.in, System.out);
    }
}
