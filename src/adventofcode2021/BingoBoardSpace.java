package adventofcode2021;

public class BingoBoardSpace {
    private boolean found = false;
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean isFound() {
        return found;
    }

    public String getValue() {
        return value;
    }
}
