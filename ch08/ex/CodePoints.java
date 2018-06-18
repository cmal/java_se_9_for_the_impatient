package ch08.ex;

import java.util.*;
import java.util.stream.*;
import java.math.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;
// import java.util.Map.Entry;

public class CodePoints {

    public static Stream<String> codePoints(String s) {
        var offsetStream = IntStream.iterate(0,
                                             i -> i < s.length(),
                                             i -> s.offsetByCodePoints(i, 1));
        return offsetStream.mapToObj(i -> s.substring(i, s.offsetByCodePoints(i, 1)));
    }

    public static boolean isLetterOnlyWord(String s) {
        return s.codePoints().reduce(0, (cur, next) -> Character.isAlphabetic(next) ? cur : cur + 1) == 0;
    }

    public static boolean occurExactlyOneTime(String s, String vowel) {
        return s.indexOf(vowel) != -1 && s.indexOf(vowel) == s.lastIndexOf(vowel);
    }

    public static boolean containFiveDistinctVowels(String s) {
        var ss = s.toLowerCase();
        return occurExactlyOneTime(s, "a") &&
            occurExactlyOneTime(s, "e") &&
            occurExactlyOneTime(s, "i") &&
            occurExactlyOneTime(s, "o") &&
            occurExactlyOneTime(s, "u");
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        return Long.MAX_VALUE != stream.spliterator().estimateSize();
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterFirst = first.iterator();
        Iterator<T> iterSecond = second.iterator();
        // boolean flag = false;
        // T init = null;
        // if (iterFirst.hasNext()) {
        //     init = iterFirst.next();
        //     flag = false;
        // } else if (iterSecond.hasNext()) {
        //     init = iterSecond.next();
        //     flag = true;
        // } else {
        //     return Stream.empty();
        // }

        // return Stream.iterate(init,
        // // NOT WORK BECAUSE错误: 从lambda 表达式引用的本地变量必须
        // // 是最终变量或实际上的最终变量
        //                       a -> iterFirst.hasNext() || iterSecond.hasNext(),
        //                       a -> {
        //                           if (flag) {
        //                               return iterFirst.hasNext() ? iterFirst.next() : null;
        //                           } else {
        //                               return iterSecond.hasNext() ? iterSecond.next() : null;
        //                           }
        //                       });

        // will produce INFINITE elements
        IntStream s = IntStream.iterate(0, i -> 1 - i);
        return s.mapToObj(i -> {
                if (i == 0) {
                    return iterFirst.hasNext() ? iterFirst.next() : null;
                } else {
                    return iterSecond.hasNext() ? iterSecond.next() : null;
                }
            });
    }

    public static <T> ArrayList<T> join1(Stream<ArrayList<T>> stream) {
        return stream.reduce((a, b) -> {
                a.addAll(b);
                return a;
            }).get();
    }

    public static <T> ArrayList<T> join2(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<T>(),
                             (a, b) -> {
                                 a.addAll(b);
                                 return a;
                             });
    }

    public static double average(Stream<Double> stream) {
        var iter = IntStream.iterate(0, i -> i + 1).iterator();
        var sum = stream.reduce(0.0, (acc, cur) -> {
                iter.next();
                return acc + cur;
            });
        return sum / iter.next();
    }

    public static <T> ArrayList<T> join3(Stream<ArrayList<T>> stream) {

        // combiner is only needed for parallel streams, to combine
        // the accumulated results of threads
        return stream.reduce(new ArrayList<T>(),
                             (a, b) -> {
                                 a.addAll(b);
                                 return a;
                             },
                             (a, b) -> {
                                 a.addAll(b);
                                 return a;
                             });

    }

    public static ArrayList<String> buildList1() {
        var lst = new ArrayList<String>();
        lst.add("A");
        lst.add("B");
        return lst;
    }

    public static ArrayList<String> buildList2() {
        var lst = new ArrayList<String>();
        lst.add("a");
        lst.add("b");
        lst.add("z");
        return lst;
    }

    public static ArrayList<String> buildList3() {
        var lst = new ArrayList<String>();
        lst.add(".");
        lst.add(",");
        lst.add(":");
        lst.add(";");
        return lst;
    }

    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("words.txt")),
                                         StandardCharsets.UTF_8);
            List<String> words = List.of(contents.split("\n"));
            words.stream().flatMap(w -> codePoints(w)).limit(10).forEach(System.out::println);
            System.out.println(isLetterOnlyWord("word"));
            System.out.println(isLetterOnlyWord("中国"));
            System.out.println(isLetterOnlyWord("not alphabetic"));

            // 7. Turning a file into a stream of tokens, list the first
            // 100 tokens that are words in the sense of the preceding
            // exercise. Read the file again and list the 10 most frequent
            // words, ignoring letter case.

            var file = new File("words.txt");
            var tokens = new Scanner(file).tokens(); // Stream<String>

            tokens.filter(CodePoints::isLetterOnlyWord).limit(10).forEach(System.out::println);

            tokens = new Scanner(file).tokens();
            var mp = tokens.collect(Collectors
                                    .toMap(s -> s.toLowerCase(), // produce keys
                                           s -> 1,
                                           (a, b) -> a + b));

            mp.entrySet().stream().sorted(Map.Entry.comparingByValue((i,j) -> j - i))
                .limit(20).forEach(System.out::println);


            var dict = new File("/usr/share/dict/words");
            tokens = new Scanner(dict).tokens();
            tokens.filter(CodePoints::containFiveDistinctVowels)
                .forEach(System.out::println);

            // System.out.println(tokens.filter(CodePoints::containFiveDistinctVowels).count());

            tokens = new Scanner(dict).tokens();
            double average = tokens.collect(Collectors.summarizingInt(String::length)).getAverage();
            System.out.printf("Average length: %f\n", average);

            tokens = new Scanner(dict).tokens();
            var mp1 = tokens.collect(Collectors.groupingBy(String::length));
            mp1.entrySet().stream().sorted(Map.Entry.comparingByKey((i,j) -> j - i))
                .limit(1).forEach(System.out::println);

            tokens = new Scanner(dict).tokens();
            System.out.printf("isFinite: %b\n", isFinite(tokens)); // false

            tokens = new Scanner(file).tokens();
            System.out.printf("isFinite: %b\n", isFinite(tokens)); // false

            var finallyFile = new File("finally.txt");
            tokens = new Scanner(finallyFile).tokens();
            System.out.printf("isFinite: %b\n", isFinite(tokens)); // false

            System.out.printf("isFinite: %b\n", isFinite(words.stream())); // true

            var floatingFile = new File("floating.txt");
            zip(new Scanner(finallyFile).tokens(),
                new Scanner(floatingFile).tokens())
                .limit(30)
                .forEach(System.out::println);

            var lst1 = buildList1();
            var lst2 = buildList2();
            var lst3 = buildList3();

            var lst = new ArrayList<ArrayList<String>>();
            lst.add(lst1);
            lst.add(lst2);
            lst.add(lst3);

            join1(lst.stream()).forEach(System.out::println);
            System.out.println("-----");
            // lst, lst1 are changed

            lst = new ArrayList<ArrayList<String>>();
            lst1 = buildList1();
            lst2 = buildList2();
            lst3 = buildList3();
            lst.add(lst1);
            lst.add(lst2);
            lst.add(lst3);
            join2(lst.stream()).forEach(System.out::println);

            System.out.println("-----");

            lst = new ArrayList<ArrayList<String>>();
            lst1 = buildList1();
            lst2 = buildList2();
            lst3 = buildList3();
            lst.add(lst1);
            lst.add(lst2);
            lst.add(lst3);
            join3(lst.stream()).forEach(System.out::println);

            // 8-15
            ArrayList<Double> db = new ArrayList<>();
            db.add(1.0);
            db.add(2.0);
            db.add(3.0);
            System.out.println(average(db.stream()));

            // the question of 8-15
            // because the stream will be consumed after compute sum,
            // and cannot count(), unless one build the stream again,
            // which will not be acceptable.

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
