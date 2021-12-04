package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D4P2 implements PuzzleBasics {
    private int getNrOfWonBoards(List<BingoBoard> bingoBoards) {
        int nrOfWonBoards = 0;
        for (BingoBoard board : bingoBoards) {
            if (board.isWin()) {
                nrOfWonBoards++;
            }
        }
        return nrOfWonBoards;
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> drawnNumbers = reader.readDrawnNumbers("resources/day4.txt");
        List<BingoBoard> bingoBoards = reader.readBingoBoards("resources/day4.txt");

        for (String drawnNumber : drawnNumbers) {
            for (BingoBoard board : bingoBoards) {
                if (!board.isWin()) {
                    board.pinValue(drawnNumber);
                    for (int i = 0; i < 5; i++) {
                        if (board.checkTrueCol(i) || board.checkTrueRow(i)) {
                            board.setWin(true);
                            if (getNrOfWonBoards(bingoBoards) == bingoBoards.size()) {
                                board.printBingoScore(drawnNumber);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}