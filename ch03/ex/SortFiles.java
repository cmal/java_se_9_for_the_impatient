package ch03.ex;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class SortFiles {

    public static void main(String[] args) {
        File f = new File(".");
        File[] files = f.listFiles();

        Comparator<File> compCate = new Comparator<File>() {
                @Override
                public int compare(File f1, File f2) {
                    int t1 = f1.isDirectory() ? 0 : 1;
                    int t2 = f2.isDirectory() ? 0 : 1;
                    return t1 - t2;
                }
            };

        Comparator<File> comp = compCate
            .thenComparing((f1, f2) -> f1.getName().compareTo(f2.getName()));

    

        Arrays.sort(files, comp);
        for (File file : files) {
            System.out.println(file);
        }

    }
}
