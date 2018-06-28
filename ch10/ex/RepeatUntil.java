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

// 26. Write a method
// that asynchronously repeats the action until it produces a value
// that is accepted by the until function, which should also run
// asynchronously. Test with a function that reads a
// java.net.PasswordAuthentication from the console, and a function
// that simulates a validity check by sleeping for a second and then
// checking that the password is "secret". Hint: Use recursion.

public class RepeatUntil {
    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        T t = action.get();
        return until.test(t) ? CompletableFuture.completedFuture(t) :
            CompletableFuture.supplyAsync(() -> {
                    T tt = null;
                    try {
                        tt = repeat(action, until).get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return tt;
            });
    }

    public static void main(String[] args) {
        PasswordAuthentication pa = new PasswordAuthentication("user1", "secret".toCharArray());
        Supplier<String> getPasswd = () -> {
            System.out.print("Verify user's password: ");
            Scanner in = new Scanner(System.in);
            String passwd = in.nextLine();
            return passwd;
        };
        Predicate<String> validityCheck = s -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Arrays.equals(s.toCharArray(), pa.getPassword());
        };
        CompletableFuture<String> f = repeat(getPasswd, validityCheck);
        f.join();
        f.whenComplete((s, t) -> {
                if (t == null) {
                    System.out.println(s);
                } else {
                    t.printStackTrace();
                }
            });
    }
}

