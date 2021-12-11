package adventofcode2021;

public class OctopusGrid {
    private int[][] map;

    public OctopusGrid(int[][] map) {
        this.map = map;
    }

    public void increaseEnergy() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j]++;
            }
        }
    }

    public boolean hasOver9 () {
        for (int[] line : map) {
            for (int octopus : line) {
                if (octopus > 9) {
                    return true;
                }
            }
        }
        return false;
    }

    private void increaseNeighbors(int i, int j) {
        if (i != 0) {
            if (j != 0 && map[i - 1][j - 1] != 0) {
                map[i - 1][j - 1]++;
            }
            if (j != 9 && map[i - 1][j + 1] != 0) {
                map[i - 1][j + 1]++;
            }
            if (map[i - 1][j] != 0) {
                map[i - 1][j]++;
            }
        }
        if (i != 9) {
            if (j != 0 && map[i + 1][j - 1] != 0) {
                map[i + 1][j - 1]++;
            }
            if (j != 9 && map[i + 1][j + 1] != 0) {
                map[i + 1][j + 1]++;
            }
            if (map[i + 1][j] != 0) {
                map[i + 1][j]++;
            }
        }
        if (j != 0 && map[i][j - 1] != 0) {
            map[i][j - 1]++;
        }
        if (j != 9 && map[i][j + 1] != 0) {
            map[i][j + 1]++;
        }
        if (map[i][j] != 0) {
            map[i][j]++;
        }
    }

    public int flash() {
        int nrOfFlashes = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] > 9 && map[i][j] != 0) {
                    map[i][j] = 0;
                    increaseNeighbors(i, j);
                    nrOfFlashes++;
                }
            }
        }
        return nrOfFlashes;
    }
}
