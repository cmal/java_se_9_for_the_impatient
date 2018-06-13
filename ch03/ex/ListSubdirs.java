package ch03.ex;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class ListSubdirs {
    public static ArrayList<File> listSubdirs(File dir) {
        ArrayList<File> ret = new ArrayList<File>();
        if (!dir.isDirectory()) {
            // System.out.printf("%s is NOT a directory!\n", dir);
            return ret;
        }

        ret.add(dir);
        FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            };

        File[] dirs = dir.listFiles(filter);

        for (File d : dirs) {
            for (File d1 : listSubdirs(d)) {
                ret.add(d);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        for (File dir : listSubdirs(new File("Makefile"))) {
            System.out.println(dir);
        }
        for (File dir : listSubdirs(new File("."))) {
            System.out.println(dir);
        }
        
    }
}
