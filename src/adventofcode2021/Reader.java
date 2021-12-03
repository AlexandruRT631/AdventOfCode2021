package adventofcode2021;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {
    public List<String> readFromInput(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        return lines;
    }

}