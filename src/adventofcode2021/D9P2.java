package adventofcode2021;

import java.io.IOException;

public class D9P2 implements PuzzleBasics {
    public int DFS(MapCoordinate[][] map, int i, int j) {
        if (map[i][j].getValue() == 9) {
            return 0;
        }
        map[i][j].setVisited(true);
        int areaSize = 0;
        if (i >= 1 && !map[i - 1][j].isVisited()) {
            areaSize = 1 + DFS(map, i - 1, j);
        }
        if (i <= map.length - 2 && !map[i + 1][j].isVisited()) {
            areaSize = areaSize + 1 + DFS(map, i + 1, j);
        }
        if (j >= 1 && !map[i][j - 1].isVisited()) {
            areaSize = areaSize + 1 + DFS(map, i, j - 1);
        }
        if (j <= map[i].length - 2 && !map[i][j + 1].isVisited()) {
            areaSize = areaSize + 1 + DFS(map, i, j + 1);
        }
        return areaSize;
    }


    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        MapCoordinate[][] map = reader.readMapCoordinate("resources/day9.txt");

        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                boolean lowPoint = true;
                if (i >= 1 && map[i - 1][j].getValue() <= map[i][j].getValue()) {
                    lowPoint = false;
                }
                if (lowPoint && i <= map.length - 2 && map[i + 1][j].getValue() <= map[i][j].getValue()) {
                    lowPoint = false;
                }
                if (lowPoint && j >= 1 && map[i][j - 1].getValue() <= map[i][j].getValue()) {
                    lowPoint = false;
                }
                if (lowPoint && j <= map[i].length - 2 && map[i][j + 1].getValue() <= map[i][j].getValue()) {
                    lowPoint = false;
                }
                if (lowPoint) {
                    int areaSize = DFS(map, i, j) + 1;
                    if (areaSize >= max1) {
                        max3 = max2;
                        max2 = max1;
                        max1 = areaSize;
                    }
                    else if (areaSize >= max2) {
                        max3 = max2;
                        max2 = areaSize;
                    }
                    else if (areaSize >= max3) {
                        max3 = areaSize;
                    }
                }
            }
        }
        System.out.println(max1 * max2 * max3);
    }
}
