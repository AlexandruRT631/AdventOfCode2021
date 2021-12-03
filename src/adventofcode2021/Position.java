package adventofcode2021;

import java.util.List;

public class Position {
    private Integer horizontalPosition = 0;
    private Integer depth = 0;

    public Integer getHorizontalPosition() {
        return horizontalPosition;
    }

    public Integer getDepth() {
        return depth;
    }

    public void updatePosition(List<String> input) {
        for (String line : input) {
            String[] command = line.split(" ");
            int units = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "forward":
                    horizontalPosition = horizontalPosition + units;
                    break;
                case "down":
                    depth = depth + units;
                    break;
                case "up":
                    depth = depth - units;
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
