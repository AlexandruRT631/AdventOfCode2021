package adventofcode2021;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D8P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> lines = reader.readFromInput("resources/day8.txt");
        int output = 0;
        for (String line : lines) {
            List<String> words = Arrays.stream(line.split(" ")).toList();
            int i = words.indexOf("|") + 1;
            for (int j = 0; j < 4; j++) {
                if (words.get(i + j).length() == 2 || words.get(i + j).length() == 4 || words.get(i + j).length() == 3 || words.get(i + j).length() == 7) {
                    output++;
                }
            }
        }
        System.out.println(output);
    }
}
