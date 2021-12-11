package adventofcode2021;

import java.io.IOException;

public class D11P2 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        OctopusGrid octopusGrid = new OctopusGrid(reader.readMap("resources/day11.txt"));

        int flashStep = 0;
        while (!octopusGrid.allFlash()) {
            octopusGrid.increaseEnergy();
            while (octopusGrid.hasOver9()) {
                octopusGrid.flash();
            }
            flashStep++;
        }
        System.out.println(flashStep);
    }
}
