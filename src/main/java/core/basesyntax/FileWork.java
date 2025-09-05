package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class FileWork {

    private static final String DELIMITER = " ";
    private static final String PREFIX = "w";
    private static final String REGEX = "[\\s\\p{P}]+";

    public String[] readFromFile(String fileName) {
        //write your code here
        String read = "";
        try {
            read = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }
        if (read.isBlank()) {
            return new String[0];
        }
        String[] split = read.toLowerCase().split(REGEX);
        Arrays.sort(split, Comparator.naturalOrder());
        StringJoiner joiner = new StringJoiner(DELIMITER);
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            split[i] = null;
            if (word.startsWith(PREFIX)) {
                joiner.add(word);
            }
        }
        String result = joiner.toString();
        return result.isBlank() ? new String[0] : result.split("\\s");
    }
}
