package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String read = "";
        try {
            read = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }
        String[] split = read.split("[\\s\\p{P}]+");
        Arrays.sort(split, Comparator.naturalOrder());
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (int i = 0; i < split.length; i++) {
            String word = split[i].toLowerCase();
            split[i] = null;
            if (word.startsWith("w")) {
                joiner.add(word);
            }
        }
        return joiner.toString().split("\\s");
    }
}
