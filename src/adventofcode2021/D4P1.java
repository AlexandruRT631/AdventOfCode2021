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
                        int sum = 0;
                        for (int row = 0; row < 5; row++) {
                            for (int col = 0; col < 5; col++) {
                                if (!board.isFound(row, col)) {
                                    sum = sum + Integer.parseInt(board.getValue(row, col));
                                }
                            }
                        }
                        System.out.println(sum * Integer.parseInt(drawnNumber));
                        return;
                    }
                }
            }
        }
    }
}
