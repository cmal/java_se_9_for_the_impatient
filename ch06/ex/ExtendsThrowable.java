package ch06.ex;

import java.util.function.*;
import java.util.concurrent.Callable;

public class ExtendsThrowable {

    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<Throwable, T> f) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            throw f.apply(realEx);
        }
    }

    public static class MyPersonalException extends Exception {
        public MyPersonalException(Throwable cause) {
            super(cause);
        }
    }

    public static void main(String[] args) {
        try {
            ExtendsThrowable.doWork(() -> {
                    throw new MyPersonalException(null);
                }, MyPersonalException::new);
        } catch (Exception e) {
            e.printStackTrace();
            // show Throw MyPersonalException
        }
    }
}
