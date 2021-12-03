package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D1P1 implements PuzzleBasics{
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> input = reader.readFromInput("resources/day1puzzle1.txt");

        Measurements measurements = new Measurements();
        System.out.println(measurements.getNrOfIncreasing(input));
    }
}
