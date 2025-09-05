package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

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
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].toLowerCase();
        }
        return split;
    }
}
