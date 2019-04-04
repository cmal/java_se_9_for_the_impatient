package ch09.ex;

import java.nio.file.*;
import java.nio.ByteOrder;
import java.io.*;


public class WhichCharset {

    public static void detectCharset() {
        try {
        Path file = Paths.get("finally.txt");
        // DataInput inBoolean = new DataInputStream(Files.newInputStream(file)); 
        // boolean b1 = inBoolean.readBoolean();
        // boolean b2 = inBoolean.readBoolean();
        // boolean b3 = inBoolean.readBoolean();
        // boolean b4 = inBoolean.readBoolean();
        DataInput inUTF = new DataInputStream(Files.newInputStream(file));
        // DataInput inByte = new DataInputStream(Files.newInputStream(file));
        // System.out.println(b1);
        // System.out.println(b2);
        // System.out.println(b3);
        // System.out.println(b4);
        System.out.println(inUTF.readUTF());
        // System.out.println(inByte.readByte());
        System.out.println(ByteOrder.nativeOrder().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        detectCharset();
    }
}
