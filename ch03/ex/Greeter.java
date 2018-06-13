package ch03.ex;

import java.util.function.Function;

public class Greeter implements Runnable {

    private int n;
    private String target;

    public Greeter(int argN, String argTarget) {
        n = argN;
        target = argTarget;
    }

    public void run() {
        for (int i = 0; i < n; i ++) {
            System.out.printf("Hello, %s\n", target);
        }
    }

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            Thread t = new Thread(task);
            t.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    // https://stackoverflow.com/questions/29945627/java-8-lambda-void-argument
    public static Function<Runnable[] , Void> returnRunnable() {
        return (tasks) -> {
            for (Runnable task : tasks) {
                task.run();
            }
            return null;
        };
    }


    public static void main(String[] args) {
        Runnable g1 = new Greeter(100, "Tom");
        Runnable g2 = new Greeter(100, "Jack");
        // runTogether(g1, g2);
        // runInOrder(g1, g2);
        Function<Runnable[] , Void> r = returnRunnable();
        r.apply(new Runnable[]{g1, g2});
    }
}
