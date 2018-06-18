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
                                           (a, b) -> a + b)
                                    );

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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
