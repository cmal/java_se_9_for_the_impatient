package ch08.ex;

import java.util.*;
import java.util.stream.*;
import java.math.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;

public class CodePoints {

    public static Stream<String> codePoints(String s) {
        var offsetStream = IntStream.iterate(1,
                                             i -> i < s.length(),
                                             i -> s.offsetByCodePoints(i, 1));
        return offsetStream.mapToObj(i -> s.substring(i, s.offsetByCodePoints(i, 1)));
    }

    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("words.txt")),
                                         StandardCharsets.UTF_8);
            List<String> words = List.of(contents.split("\n"));
            var stream = words.stream().flatMap(w -> codePoints(w)).limit(100);
            System.out.println(Arrays.asList(stream.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
