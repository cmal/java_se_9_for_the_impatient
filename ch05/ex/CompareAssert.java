package ch05.ex;

import java.util.Objects;

public class CompareAssert {

    public static void compareAssert(Object obj) {
        Objects.requireNonNull(obj); // NullPointerException

        // only when java -ea ch05/ex/CompareAssert
        assert obj != null; // java.lang.AssertionError
    }

    public static void main(String[] args) {
        String obj = null;
        // String obj1 = "saf";
        compareAssert(obj);
        // compareAssert(obj1);
    }
}
