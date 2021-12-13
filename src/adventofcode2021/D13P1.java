package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D13P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        Paper paper = new Paper(reader.readPaper("resources/day13.txt"));
        List<Fold> folds = reader.readFoldings("resources/day13.txt");

        paper.fold(folds.get(0));
        System.out.println(paper.getNrOfDots());
    }
}
