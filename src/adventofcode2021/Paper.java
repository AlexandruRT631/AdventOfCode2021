package adventofcode2021;

public class Paper {
    boolean[][] paper;

    public Paper(boolean[][] paper) {
        this.paper = paper;
    }

    public void fold(Fold fold){
        int axis = fold.getAxis();
        boolean[][] newPaper;
        if (fold.isVertical()) {
            newPaper = new boolean[paper.length][axis];
            for (int i = 0; i < paper.length; i++) {
                for (int j = 0; j < axis; j++) {
                    newPaper[i][j] = paper[i][j] || paper[i][paper[0].length - 1 - j];
                }
            }
        }
        else {
            newPaper = new boolean[axis][paper[0].length];
            for (int i = 0; i < axis; i++) {
                for (int j = 0; j < paper[0].length; j++) {
                    newPaper[i][j] = paper[i][j] || paper[paper.length - 1 - i][j];
                }
            }
        }
        paper = newPaper;
    }

    public int getNrOfDots() {
        int nrOfDots = 0;
        for (boolean[] line : paper) {
            for (boolean dot : line) {
                if (dot) {
                    nrOfDots++;
                }
            }
        }
        return nrOfDots;
    }
}
