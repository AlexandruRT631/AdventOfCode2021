package adventofcode2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D6P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String line = reader.readFromInput("resources/day6.txt").get(0);
        List<Integer> lanternfish = new ArrayList<Integer>(Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).boxed().toList());
        for (int i = 0; i < 80; i++) {
            int size = lanternfish.size();
            for (int j = 0; j < size; j++) {
                if (lanternfish.get(j) == 0) {
                    lanternfish.set(j, 6);
                    lanternfish.add(8);
                }
                else {
                    int newValue = lanternfish.get(j) - 1;
                    lanternfish.set(j, newValue);
                }
            }
        }
        System.out.println(lanternfish.size());
    }
}
