package adventofcode2021;

import java.io.IOException;
import java.util.List;

public class D5P1 implements PuzzleBasics {
    private int xMax(List<LineCoordinates> lineCoordinates) {
        int xMax = 0;
        for (LineCoordinates coordinates : lineCoordinates) {
            xMax = Math.max(xMax, Math.max(coordinates.getxStart(), coordinates.getxEnd()));
        }
        return xMax;
    }

    private int yMax(List<LineCoordinates> lineCoordinates) {
        int yMax = 0;
        for (LineCoordinates coordinates : lineCoordinates) {
            yMax = Math.max(yMax, Math.max(coordinates.getyStart(), coordinates.getyEnd()));
        }
        return yMax;
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<LineCoordinates> lineCoordinates = reader.readCoordinates("resources/day5.txt");

        Diagram diagram = new Diagram(xMax(lineCoordinates) + 1, yMax(lineCoordinates) + 1);
        for (LineCoordinates coordinates : lineCoordinates) {
            if (coordinates.getxStart() == coordinates.getxEnd()) {
                diagram.addHorizontalLine(coordinates);
            }
            else if (coordinates.getyStart() == coordinates.getyEnd()) {
                diagram.addVerticalLine(coordinates);
            }
        }

//        for (int i = 0; i < diagram.getX(); i++) {
//            for (int j = 0; j < diagram.getY(); j++) {
//                System.out.print(diagram.getValue(j, i) + " ");
//            }
//            System.out.println();
//        }

        int nrOfIntersectionPoints = 0;
        for (int i = 0; i < diagram.getX(); i++) {
            for (int j = 0; j < diagram.getY(); j++) {
                if (diagram.getValue(j, i) > 1) {
                    nrOfIntersectionPoints++;
                }
            }
        }
        System.out.println(nrOfIntersectionPoints);
    }
}
