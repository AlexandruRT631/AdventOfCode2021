package adventofcode2021;

import java.io.IOException;
import java.util.Arrays;

public class D6P2 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String line = reader.readFromInput("resources/day6.txt").get(0);
        int[] input = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        long[] freq = new long[9];
        for (int in : input) {
            freq[in]++;
        }
        for (int i = 0; i < 256; i++) {
            long aux = freq[0];
            for (int j = 0; j < 8; j++) {
                freq[j] = freq[j + 1];
            }
            freq[6] = freq[6] + aux;
            freq[8] = aux;
        }
        long sum = 0;
        for (long nrOfFish : freq) {
            sum = sum + nrOfFish;
        }
        System.out.println(sum);
    }
}
