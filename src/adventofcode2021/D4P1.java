package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D4P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> drawnNumbers = reader.readDrawnNumbers("resources/day4.txt");
        List<BingoBoard> bingoBoards = reader.readBingoBoards("resources/day4.txt");

        for (String drawnNumber : drawnNumbers) {
            for (BingoBoard board : bingoBoards) {
                board.pinValue(drawnNumber);
                for (int i = 0; i < 5; i++) {
                    if (board.checkTrueCol(i) || board.checkTrueRow(i)) {
                        board.printBingoScore(drawnNumber);
                        return;
                    }
                }
            }
        }
    }
}
