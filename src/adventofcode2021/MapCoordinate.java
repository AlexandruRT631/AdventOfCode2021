package adventofcode2021;

public class MapCoordinate {
    private int value;
    private boolean visited;

    public MapCoordinate(int value) {
        this.value = value;
        if (value == 9) {
            this.visited = true;
        }
        else {
            this.visited = false;
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
