package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D3P1 implements PuzzleBasics{
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> input = reader.readFromInput("resources/day3.txt");

        Rate rate = new Rate();
        System.out.println(rate.getGammaRate(input) * rate.getEpsilonRate(input));
    }
}
