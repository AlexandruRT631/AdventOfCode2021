package adventofcode2021;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D8P2 implements PuzzleBasics {
    public String convertAlphabetically(String oldString) {
        char[] aux = oldString.toCharArray();
        Arrays.sort(aux);
        return Arrays.toString(aux);
    }

    public int charsBNotInA(String a, String b) {
        // returns the number of chars from string A that are not in B
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        int chars = 0;
        for (int i = 0; i < second.length; i++) {
            boolean contains = false;
            for (int j = 0; j < first.length && !contains; j++) {
                if (first[j] == second[i]) {
                    contains = true;
                }
            }
            if (!contains) {
                chars++;
            }
        }
        return chars;
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> lines = reader.readFromInput("resources/day8.txt");

        String[] segmentNumber = new String[10];

        int total = 0;
        for (String line : lines) {
            List<String> words = Arrays.stream(line.split(" ")).toList();
            int i;
            String[] possible069 = new String[3];
            int indexPossible069 = 0;
            String[] possible235 = new String[3];
            int indexPossible235 = 0;
            for (i = 0; i < 10; i++) {
                String word = words.get(i);
                switch (word.length()) {
                    case 2:
                        segmentNumber[1] = convertAlphabetically(word);
                        break;
                    case 4:
                        segmentNumber[4] = convertAlphabetically(word);
                        break;
                    case 3:
                        segmentNumber[7] = convertAlphabetically(word);
                        break;
                    case 7:
                        segmentNumber[8] = convertAlphabetically(word);
                        break;
                    case 6:
                        possible069[indexPossible069] = convertAlphabetically(word);
                        indexPossible069++;
                        break;
                    case 5:
                        possible235[indexPossible235] = convertAlphabetically(word);
                        indexPossible235++;
                        break;
                    default:
                        System.out.println("ERROR!");
                        break;
                }
            }

            // 9 contains all values of 4 (0 and 6 don't)
            if (charsBNotInA(possible069[0], segmentNumber[4]) == 0) {
                segmentNumber[9] = possible069[0];
                possible069[0] = possible069[2];
            }
            else if (charsBNotInA(possible069[1], segmentNumber[4]) == 0) {
                segmentNumber[9] = possible069[1];
                possible069[1] = possible069[2];
            }
            else {
                segmentNumber[9] = possible069[2];
            }
            // then 0 contains all values of 7 (6 doesn't)
            // and the remaining value is 6
            if (charsBNotInA(possible069[0], segmentNumber[7]) == 0) {
                segmentNumber[0] = possible069[0];
                segmentNumber[6] = possible069[1];
            }
            else {
                segmentNumber[0] = possible069[1];
                segmentNumber[6] = possible069[0];
            }

            // 3 contains 1 (2 and 5 don't)
            if (charsBNotInA(possible235[0], segmentNumber[1]) == 0) {
                segmentNumber[3] = possible235[0];
                possible235[0] = possible235[2];
            }
            else if (charsBNotInA(possible235[1], segmentNumber[1]) == 0) {
                segmentNumber[3] = possible235[1];
                possible235[1] = possible235[2];
            }
            else {
                segmentNumber[3] = possible235[2];
            }
            // then 5 contains all values from 4 except one of them (2 contains all values from 4 expect two of them)
            if (charsBNotInA(possible235[0], segmentNumber[4]) == 1) {
                segmentNumber[5] = possible235[0];
                segmentNumber[2] = possible235[1];
            }
            else {
                segmentNumber[5] = possible235[1];
                segmentNumber[2] = possible235[0];
            }

            int entry = 0;
            i++;
            for (int j = 0; j < 4; j++) {
                String word = convertAlphabetically(words.get(i + j));
                for (int k = 0; k < 10; k++) {
                    if (segmentNumber[k].equals(word)) {
                        entry = entry * 10 + k;
                    }
                }
            }
            total = total + entry;
        }
        System.out.println(total);
    }
}
