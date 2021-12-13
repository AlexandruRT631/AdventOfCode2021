package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D13P2 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        Paper paper = new Paper(reader.readPaper("resources/day13.txt"));
        List<Fold> folds = reader.readFoldings("resources/day13.txt");

        for (Fold fold : folds) {
            paper.fold(fold);
        }
        paper.printPaper();
    }
}
