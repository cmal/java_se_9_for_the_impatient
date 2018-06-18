package ch08.ex;

import java.util.*;
import java.util.stream.*;
import java.math.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;

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

    public static <T> void print(Stream<T> stream) {
        System.out.println(Arrays.asList(stream.toArray()));
    }

    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("words.txt")),
                                         StandardCharsets.UTF_8);
            List<String> words = List.of(contents.split("\n"));
            var stream = words.stream().flatMap(w -> codePoints(w)).limit(100);
            print(stream);
            System.out.println(isLetterOnlyWord("word"));
            System.out.println(isLetterOnlyWord("中国"));
            System.out.println(isLetterOnlyWord("not alphabetic"));

            // 7. Turning a file into a stream of tokens, list the first
            // 100 tokens that are words in the sense of the preceding
            // exercise. Read the file again and list the 10 most frequent
            // words, ignoring letter case.

            var file = new File("words.txt");
            var tokens = new Scanner(file).tokens(); // Stream<String>

            print(tokens.filter(s -> isLetterOnlyWord(s)).limit(100));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
