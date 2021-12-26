package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D18P1 implements PuzzleBasics{
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<Pair> pairs = reader.readPairs("resources/day18.txt");
        System.out.println();
    }
}
