package adventofcode2021;

import static java.lang.Math.abs;

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

    public void addDiagonalLine (LineCoordinates coordinates) {
        int xStart = coordinates.getxStart();
        int xEnd = coordinates.getxEnd();
        int yStart = coordinates.getyStart();
        int yEnd = coordinates.getyEnd();
        int dirx = xStart < xEnd? 1 : -1;
        int diry = yStart < yEnd? 1 : -1;

        for (int i = 0; i < abs(xStart - xEnd) + 1; i++) {
            diagram[xStart + i * dirx][yStart + i * diry]++;
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
