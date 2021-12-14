package adventofcode2021;

import java.io.IOException;

public class D14P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        Polymer polymer = new Polymer(reader.readFirstLine("resources/day14.txt"), reader.readHashMap("resources/day14.txt"));
        for (int i = 0; i < 40; i++) {
            polymer.nextStep();
        }
        System.out.println(polymer.difMcLcElem());
    }
}
