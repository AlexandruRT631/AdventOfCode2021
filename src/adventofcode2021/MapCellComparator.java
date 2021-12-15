package adventofcode2021;

import java.util.Comparator;

public class MapCellComparator implements Comparator<MapCell> {
    public int compare(MapCell a, MapCell b) {
        if (a.getDistance() < b.getDistance()) {
            return -1;
        } else if (a.getDistance() > b.getDistance()) {
            return 1;
        }
        return 0;
    }
}
