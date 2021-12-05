package adventofcode2021;

public class Diagram {
    int[][] diagram;
    int x;
    int y;

    public Diagram(int x, int y) {
        diagram = new int[x][y];
        this.x = x;
        this.y = y;
    }

    public void addHorizontalLine (LineCoordinates coordinates) {
        int yStart = Math.min(coordinates.getyStart(), coordinates.getyEnd());
        int yEnd = yStart != coordinates.getyStart() ? coordinates.getyStart() : coordinates.getyEnd();
        int x = coordinates.getxStart();
        for (; yStart <= yEnd; yStart++) {
            diagram[x][yStart]++;
        }
    }

    public void addVerticalLine (LineCoordinates coordinates) {
        int xStart = Math.min(coordinates.getxStart(), coordinates.getxEnd());
        int xEnd = xStart != coordinates.getxStart() ? coordinates.getxStart() : coordinates.getxEnd();
        int y = coordinates.getyStart();
        for (; xStart <= xEnd; xStart++) {
            diagram[xStart][y]++;
        }
    }

    public int getValue(int x, int y) {
        return diagram[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
