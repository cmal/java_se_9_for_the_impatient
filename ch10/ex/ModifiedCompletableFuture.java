package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.regex.*;
import java.net.*;
import java.util.function.*;


// 27. Implement a static method CompletableFuture<T> <T>
// supplyAsync(Supplier<T> action, Executor exec) that returns an
// instance of a subclass of CompletableFuture<T> whose cancel method
// can interrupt the thread that executes the action method, provided
// the task is running. In a Runnable, capture the current thread,
// then call action.get(), and complete the CompletableFuture with the
// result or exception.

public class ModifiedCompletableFuture<T> extends CompletableFuture<T> {

    public class Action implements Runnable {

        private Supplier<T> action;

        Action(Supplier<T> action) {
            this.action = action;
        }
        
        @Override
        public void run() {
            
        }
    }

    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> action, Executor exec) {
        Thread th = null;
        exec.execute(() -> {
                th = Thread.currentThread();
                T t = action.get();
            });
        ModifiedCompletableFuture<T> mcf = new ModifiedCompletableFuture<>(CompletableFuture.supplyAsync(action, exec), th);
        mcf.whenComplete((v,t)-> {
                if(t == null)
                    System.out.println(v);
                else
                    t.printStackTrace();
        });
        return mcf;
    }

    private final CompletableFuture<T> base;
    private final Thread t;
    
    ModifiedCompletableFuture(CompletableFuture<T> base, Thread t) {
        this.base = base;
        this.t = t;
    }

    public void cancel() {
        if (t == null) return;
        if (t.isAlive())
            t.interrupt();
    }

    public static void main(String[] args) {
        
    }
    
}

