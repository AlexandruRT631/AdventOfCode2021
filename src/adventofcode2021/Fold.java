package adventofcode2021;

public class Fold {
    private int axis;
    private boolean vertical;

    public Fold(int axis, boolean vertical) {
        this.axis = axis;
        this.vertical = vertical;
    }

    public int getAxis() {
        return axis;
    }

    public boolean isVertical() {
        return vertical;
    }
}
