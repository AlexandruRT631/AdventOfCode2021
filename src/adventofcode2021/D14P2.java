package adventofcode2021;

import java.io.IOException;

<<<<<<< HEAD
public class D14P2 implements PuzzleBasics {
=======
public class D14P1 implements PuzzleBasics {
>>>>>>> da9e6308fe7e736c3d954f9bd2b713b433bc3994
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
