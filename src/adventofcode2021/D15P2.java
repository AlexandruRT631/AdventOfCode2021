package adventofcode2021;

import java.io.IOException;
import java.util.PriorityQueue;

public class D15P2 implements PuzzleBasics {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};

    public int minRisk(int[][] map, int x, int y) {
        int[][] dist = new int[map[0].length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[x][y] = map[x][y];
        PriorityQueue<MapCell> pq = new PriorityQueue<MapCell>(map[0].length * map.length, new MapCellComparator());
        pq.add(new MapCell(x, y, dist[x][y]));
        while (!pq.isEmpty()) {
            MapCell curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                int rows = curr.getX() + dx[i];
                int cols = curr.getY() + dy[i];

                if (rows >= 0 && cols >= 0 && rows < map.length && cols < map[0].length) {
                    if (dist[rows][cols] > dist[curr.getX()][curr.getY()] + map[rows][cols]) {
                        if (dist[rows][cols] != Integer.MAX_VALUE) {
                            MapCell adj = new MapCell(rows, cols, dist[rows][cols]);
                            pq.remove(adj);
                        }
                        dist[rows][cols] = dist[curr.getX()][curr.getY()] + map[rows][cols];
                        pq.add(new MapCell(rows, cols, dist[rows][cols]));
                    }
                }
            }
        }

        return dist[map[0].length - 1][map.length - 1];
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        int[][] smallMap = reader.readMap("resources/day15.txt");
        int[][] map = new int[smallMap[0].length * 5][smallMap.length * 5];
        for (int i = 0; i < smallMap[0].length; i++) {
            System.arraycopy(smallMap[i], 0, map[i], 0, smallMap.length);
        }
        for (int i = 0; i < smallMap[0].length; i++) {
            for (int j = smallMap.length; j < map.length; j++) {
                map[i][j] = map[i][j - smallMap.length] + 1;
                if (map[i][j] == 10) {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = smallMap[0].length; i < map[0].length; i++) {
            for (int j = 0; j < smallMap.length; j++) {
                map[i][j] = map[i - smallMap[0].length][j] + 1;
                if (map[i][j] == 10) {
                    map[i][j] = 1;
                }
            }
            for (int j = smallMap.length; j < map.length; j++) {
                map[i][j] = map[i][j - smallMap.length] + 1;
                if (map[i][j] == 10) {
                    map[i][j] = 1;
                }
            }
        }
        System.out.println(Math.min(minRisk(map, 0, 1), minRisk(map, 1, 0)));
    }
}
