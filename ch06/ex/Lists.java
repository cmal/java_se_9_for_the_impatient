package ch06.ex;

import java.util.List;

public class Lists {
    public static <T> void swapHelper(List<T> elements,
                                      int i,
                                      int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

}
