package adventofcode2021;

public class Cave {
    private String cave;
    private boolean oneVisit;
    private boolean visited;

    public Cave(String cave) {
        this.cave = cave;
        oneVisit = cave.charAt(0) >= 'a' && cave.charAt(0) <= 'z';
        visited = false;
    }

    public String getCave() {
        return cave;
    }

    public boolean isOneVisit() {
        return oneVisit;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
