package ch06.ex;

import java.util.ArrayList;

public class ImprovedCloseAll {

    private int count = 0;
    private Exception ex;

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems)
        throws Exception {
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                if (count == 0) {
                    ex = e;
                    count ++;
                } else {
                    Exception tmp = ex;
                    ex = e;
                    ex.initCause(tmp);
                }
            }
        }
        if (count != 0) {
            throw ex;
        }
    }
}
