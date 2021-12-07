package adventofcode2021;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.abs;

public class D7P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String line = reader.readFromInput("resources/day7.txt").get(0);
        int[] positions = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(positions);
        int median;
        if (positions.length % 2 == 1) {
            median = positions[positions.length / 2 - 1];
        }
        else {
            median = (positions[positions.length / 2] + positions[positions.length / 2 - 1]) / 2;
        }
        int fuel = 0;
        for (int position : positions) {
            fuel = fuel + abs(position - median);
        }
        System.out.println(fuel);
    }
}
