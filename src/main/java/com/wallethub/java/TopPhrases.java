package com.wallethub.java;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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

            lines.forEach( s -> {
                String[] phrases = s.split("|");

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
