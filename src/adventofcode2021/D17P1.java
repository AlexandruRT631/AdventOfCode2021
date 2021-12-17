package adventofcode2021;

import java.io.IOException;

public class D17P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        int[] targetArea = reader.readTargetArea("resources/day17.txt");
        int xPoz = 0;
        int xVel = 1;
        int yVel;
        while (xPoz < targetArea[0]) {
            xPoz = xPoz + xVel;
            xVel++;
        }
        xVel--;
        if (targetArea[2] < 0) {
            yVel = Math.min(targetArea[2], targetArea[3]) * (-1) - 1;
        }
        else {
            yVel = Math.min(targetArea[2], targetArea[3]) - 1;
        }
        System.out.println(yVel * (yVel + 1) / 2);
    }
}
