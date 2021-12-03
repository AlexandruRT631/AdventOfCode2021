package adventofcode2021;

import java.util.List;

public class Measurements {
    private Integer nrOfIncreasing = 0;

    public void setNrOfIncreasing(Integer nrOfIncreasing) {
        this.nrOfIncreasing = nrOfIncreasing;
    }

    public Integer getNrOfIncreasing(List<String> input) {
        String previous = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            String current = input.get(i);
            if (Integer.parseInt(previous) < Integer.parseInt(current)) {
                nrOfIncreasing++;
            }
            previous = current;
        }
        return nrOfIncreasing;
    }

    public Integer getNrOfAccurateIncreasing(List<String> input) {
        int previous = Integer.parseInt(input.get(0)) + Integer.parseInt(input.get(1)) + Integer.parseInt(input.get(2));
        for (int i = 3; i < input.size(); i++) {
            int current = previous - Integer.parseInt(input.get(i - 3)) + Integer.parseInt(input.get(i));
            if (previous < current) {
                nrOfIncreasing++;
            }
            previous = current;
        }
        return nrOfIncreasing;

    }
}
