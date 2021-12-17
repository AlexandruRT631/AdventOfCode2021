package adventofcode2021;

import java.io.IOException;

public class D17P2 implements PuzzleBasics {
    private boolean canReachTargetArea(int[] targetArea, int xVel, int yVel) {
        int xPoz = 0;
        int yPoz = 0;
        int i = xVel;
        int j = yVel;
        while (xPoz <= targetArea[1] && yPoz >= targetArea[2]) {
            if (xPoz >= targetArea[0] && yPoz <= targetArea[3]) {
                return true;
            }
            xPoz = xPoz + i;
            yPoz = yPoz + j;
            if (i != 0) {
                i--;
            }
            j--;
        }
        return false;
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        int[] targetArea = reader.readTargetArea("resources/day17.txt");

        int xPoz = 0;
        int xVelMin = 1;
        while (xPoz < targetArea[0]) {
            xPoz = xPoz + xVelMin;
            xVelMin++;
        }
        xVelMin--;

        int yVelMin = Math.min(targetArea[2], targetArea[3]);
        int yVelMax = Math.min(targetArea[2], targetArea[3]) * (-1) - 1;


        int possibilities = 0;
        for (int xVel = xVelMin; xVel <= targetArea[1]; xVel++) {
            for (int yVel = yVelMin; yVel <= yVelMax; yVel++) {
                if (canReachTargetArea(targetArea, xVel, yVel)) {
                    possibilities++;
                }
            }
        }
//        if (targetArea[2] < 0) {
//            yVel = Math.min(targetArea[2], targetArea[3]) * (-1) - 1;
//        }
//        else {
//            yVel = Math.min(targetArea[2], targetArea[3]) - 1;
//        }
        System.out.println(possibilities);
    }
}
