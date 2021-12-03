package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D1P2 {
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> input = reader.readFromInput("resources/day1puzzle2.txt");

        Measurements measurements = new Measurements();
        System.out.println(measurements.getNrOfAccurateIncreasing(input));
    }
}
