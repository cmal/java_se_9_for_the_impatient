package ch03.ex;

import java.io.File;
import java.io.FileFilter;

public class ListSubdirs {
    public static void listSubdirs(File dir) {
        if (!dir.isDirectory()) {
            // System.out.printf("%s is NOT a directory!\n", dir);
            return;
        }

        FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            };

        File[] dirs = dir.listFiles(filter);

        for (File d : dirs) {
            System.out.println(d);
            listSubdirs(d);
        }
    }

    public static void main(String[] args) {
        listSubdirs(new File("Makefile"));
        listSubdirs(new File("."));
    }
}
