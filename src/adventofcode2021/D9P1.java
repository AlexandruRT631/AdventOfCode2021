package adventofcode2021;

import java.io.IOException;

public class D9P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        int[][] map = reader.readMap("resources/day9.txt");

        int risk = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                boolean lowPoint = true;
                if (i >= 1 && map[i - 1][j] <= map[i][j]) {
                    lowPoint = false;
                }
                if (lowPoint && i <= map.length - 2 && map[i + 1][j] <= map[i][j]) {
                    lowPoint = false;
                }
                if (lowPoint && j >= 1 && map[i][j - 1] <= map[i][j]) {
                    lowPoint = false;
                }
                if (lowPoint && j <= map[i].length - 2 && map[i][j + 1] <= map[i][j]) {
                    lowPoint = false;
                }
                if (lowPoint) {
                    risk = risk + map[i][j] + 1;
                }
            }
        }
        System.out.println(risk);
    }
}
