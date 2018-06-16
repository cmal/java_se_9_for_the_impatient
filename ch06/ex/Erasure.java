package ch06.ex;

public class Erasure {
    public static <T extends Comparable<? super T>>
        void sort(List<T> list);

    // ==>
    public static void sort(List<Comparable> list);

    public static <T extends Object & Comparable<? super T>>
        T max(Collection<? extends T> coll);

    // ==>
    public static Object max(Collection<Object> coll);
}
