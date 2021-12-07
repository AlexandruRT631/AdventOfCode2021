package adventofcode2021;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.abs;

public class D7P2 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String line = reader.readFromInput("resources/day7.txt").get(0);
        int[] positions = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        int positionsSum = 0;
        for (int position : positions) {
            positionsSum = positionsSum + position;
        }
        int median = positionsSum/positions.length;
        if (positions.length % 2 == 1) {
            median++;
        }
        int fuel = 0;
        for (int position : positions) {
            int aux = abs(position - median);
            fuel = fuel + aux * (aux + 1) / 2;
        }
        System.out.println(fuel);
    }
}
