package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D2P1 implements PuzzleBasics{
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> input = reader.readFromInput("resources/day2puzzle1.txt");

        Position position = new Position();
        position.updatePosition(input);
        System.out.println(position.getDepth() * position.getHorizontalPosition());

    }
}
