package adventofcode2021;

import java.util.List;

public class Rate {
    private int multiplier;

    public int getGammaRate(List<String> input) {
        int[] bitFreq = new int[input.get(0).length()];
        int maxFreq = input.size();
        for (String position : input) {
            for (int i = 0; i < position.length(); i++) {
                if (position.charAt(i) == '1') {
                    bitFreq[i]++;
                }
            }
        }
        multiplier = 1;
        int gammaRate = 0;
        for (int i = bitFreq.length - 1; i >= 0; i--) {
            if (bitFreq[i] >= maxFreq / 2) {
                gammaRate = gammaRate + multiplier;
            }
            multiplier = multiplier * 2;
        }
        return gammaRate;
    }

    public int getEpsilonRate(List<String> input) {
        int gammaRate = getGammaRate(input);
        return multiplier - gammaRate - 1;
    }
}
