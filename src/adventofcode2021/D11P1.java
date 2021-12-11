package adventofcode2021;

import java.io.IOException;

public class D11P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        OctopusGrid octopusGrid = new OctopusGrid(reader.readMap("resources/day11.txt"));

        int nrOfFlashes = 0;
        for (int i = 0; i < 100; i++) {
            octopusGrid.increaseEnergy();
            while (octopusGrid.hasOver9()) {
                nrOfFlashes = nrOfFlashes + octopusGrid.flash();
            }
        }
        System.out.println(nrOfFlashes);
    }
}
