package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D3P2 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> input = reader.readFromInput("resources/day3.txt");

        Rate rate = new Rate();
        System.out.println(rate.getOxygenRate(input, 0) * rate.getCO2Rate(input, 0));
    }
}
