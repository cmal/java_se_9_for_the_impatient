package ch03.ex;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class ListGivenExtension {
    public static ArrayList<String> listGivenExt(String dir, String ext) {

        ArrayList<String> ret = new ArrayList<String>();

        File file = new File(dir);
        if (!file.isDirectory()) {
            System.out.printf("%s is NOT a directory!\n", dir);
            return ret;
        }
        
        FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File d, String name) {
                    return name.toLowerCase().endsWith(ext);
                }
            };

        String[] files = file.list(filter);

        for (String f : files) {
            ret.add(f);
        }
        return ret;
    }

    public static void main(String[] args) {
        for (String f : listGivenExt("Makefile", "java")) {
            System.out.println(f);
        }
        for (String f : listGivenExt(".", "git")) {
            System.out.println(f);
        }
        
    }
}
