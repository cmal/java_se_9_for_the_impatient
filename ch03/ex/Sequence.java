package ch03.ex;

public interface Sequence<T> {
    boolean hasNext();
    T next();
}
