package ch03.ex;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class SortFiles {

    public static void main(String[] args) {
        File f = new File(".");
        File[] files = f.listFiles();

        Arrays.sort(files, new Comparator<File>() {
                @Override
                public int compare(File f1, File f2) {
                    int t1 = f1.isDirectory() ? 0 : 1;
                    int t2 = f2.isDirectory() ? 0 : 1;
                    return t1 - t2;
                }
            }.thenComparing((f1, f2) -> f1.getName().compareTo(f2.getName()))
            );

        for (File file : files) {
            System.out.println(file);
        }

    }
}
