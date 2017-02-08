package com.wallethub.java;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by juanroman on 6/02/17.
 */
public class TopPhrases {

    private String filename;

    public TopPhrases(String filename) {
        this.filename = filename;
    }

    public void findTopPhrasesInFile() {

        try (Stream<String> lines = Files.lines(Paths.get(filename), Charset.defaultCharset())) {

            lines.forEach( (String s) -> {
                List<String> phrases = Arrays.asList(s.split("|"));

                Map<String, Long> counted = phrases.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
