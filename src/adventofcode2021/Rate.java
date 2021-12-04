package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class Rate {
    private int binaryToInt(String binary) {
        int multiplier = 1;
        int number = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            number = number + multiplier * Integer.parseInt(String.valueOf(binary.charAt(i)));
            multiplier = multiplier * 2;
        }
        return number;
    }

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
        String gammaRate = "";
        for (int bit : bitFreq) {
            gammaRate = gammaRate + (bit >= maxFreq / 2 ? "1" : "0");
        }
        return binaryToInt(gammaRate);
    }

    public int getEpsilonRate(List<String> input) {
        int gammaRate = getGammaRate(input);
        int multiplier = 1;
        for (int i = 0; i < input.get(0).length(); i++) {
            multiplier = multiplier * 2;
        }
        return multiplier - gammaRate - 1;
    }

    private int getOneRate(List<String> input, int charPoz) {
        int oneRate = 0;
        for (String value : input) {
            if (value.charAt(charPoz) == '1') {
                oneRate++;
            }
        }
        return oneRate;
    }

    private List<String> generateNewList(List<String> oldList, int bitValue, int charPoz) {
        List<String> newList = new ArrayList<>();
        for (String value : oldList) {
            if (Integer.parseInt(String.valueOf(value.charAt(charPoz))) == bitValue) {
                newList.add(value);
            }
        }
        return newList;
    }

    public int getOxygenRate(List<String> input, int charPoz) {
        if (input.size() == 1) {
            return binaryToInt(input.get(0));
        }
        int bitValue = getOneRate(input, charPoz) >= (input.size() + 1) / 2 ? 1 : 0;
        return getOxygenRate(generateNewList(input, bitValue, charPoz), charPoz + 1);
    }

    public int getCO2Rate(List<String> input, int charPoz) {
        if (input.size() == 1) {
            return binaryToInt(input.get(0));
        }
        int bitValue = getOneRate(input, charPoz) < (input.size() + 1) / 2 ? 1 : 0;
        return getCO2Rate(generateNewList(input, bitValue, charPoz), charPoz + 1);
    }
}
