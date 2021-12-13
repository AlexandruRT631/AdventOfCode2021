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
                for (int j = 1; j <= axis; j++) {
                    if (axis + j < paper[0].length) {
                        newPaper[i][axis - j] = paper[i][axis - j] || paper[i][axis + j];
                    }
                }
            }
        }
        else {
            newPaper = new boolean[axis][paper[0].length];
            for (int i = 1; i <= axis; i++) {
                for (int j = 0; j < paper[0].length; j++) {
                    if (axis + i < paper.length) {
                        newPaper[axis - i][j] = paper[axis - i][j] || paper[axis + i][j];
                    }
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

    public void printPaper() {
        for (boolean[] line : paper) {
            for (boolean dot : line) {
                if (dot) {
                    System.out.print("#");
                }
                else System.out.print(".");
            }
            System.out.println();
        }
    }
}
