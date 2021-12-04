package adventofcode2021;

public class BingoBoard {
    private BingoBoardSpace[][] board = new BingoBoardSpace[5][5];
    boolean win = false;

    public BingoBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = new BingoBoardSpace();
            }
        }
    }

    public void setBingoBoardRow(String rowValues, int row) {
        String[] value = rowValues.split("\\s+");
        if (value[0] == "") {
            System.arraycopy(value, 1, value, 0, 5);
        }
        for (int i = 0; i < 5; i++) {
            board[row][i].setValue(value[i]);
        }
    }

    public boolean checkTrueRow(int row) {
        return board[row][0].isFound() && board[row][1].isFound() && board[row][2].isFound() && board[row][3].isFound() && board[row][4].isFound();
    }

    public boolean checkTrueCol(int col) {
        return board[0][col].isFound() && board[1][col].isFound() && board[2][col].isFound() && board[3][col].isFound() && board[4][col].isFound();
    }

    public void pinValue(String value) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j].getValue().equals(value)) {
                    board[i][j].setFound(true);
                }
            }
        }
    }

    public boolean isFound(int row, int col) {
        return board[row][col].isFound();
    }

    public String getValue(int row, int col) {
        return board[row][col].getValue();
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public void printBingoScore(String drawnNumber) {
        int sum = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (!board[row][col].isFound()) {
                    sum = sum + Integer.parseInt(board[row][col].getValue());
                }
            }
        }
        System.out.println(sum * Integer.parseInt(drawnNumber));
    }
}
