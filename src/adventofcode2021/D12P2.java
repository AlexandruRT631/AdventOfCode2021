package adventofcode2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class D12P2 implements PuzzleBasics {
    private List<Cave> generateCaveList(List<Paths> paths) {
        List<Cave> caves = new ArrayList<>();
        for (Paths path : paths) {
            String cave1 = path.getA();
            String cave2 = path.getB();
            boolean ok1 = true;
            boolean ok2 = true;
            int size = caves.size();
            for (int j = 0; j < size && (ok1 || ok2); j++) {
                if (ok1 && caves.get(j).getCave().equals(cave1)) {
                    ok1 = false;
                } else if (ok2 && caves.get(j).getCave().equals(cave2)) {
                    ok2 = false;
                }
            }
            if (ok1) {
                caves.add(new Cave(cave1));
            }
            if (ok2) {
                caves.add(new Cave(cave2));
            }
        }
        return caves;
    }

    private int findCaveIndex(List<Cave> caves, String searchedCave) {
        for (int i = 0; i < caves.size(); i++) {
            if (caves.get(i).getCave().equals(searchedCave)) {
                return i;
            }
        }
        return 0;
    }

    private int backtracking(List<Paths> paths, List<Cave> caves, String caveName, boolean twice) {
        if (caveName.equals("end")) {
            return 1;
        }
        int nrOfPaths = 0;
        for (Paths path : paths) {
            if (path.hasCave(caveName)) {
                String otherCaveName = path.getA().equals(caveName) ? path.getB() : path.getA();
                int caveIndex = findCaveIndex(caves, otherCaveName);
                Cave cave = caves.get(caveIndex);
                if (!cave.isOneVisit() || !cave.isVisited() || (twice && !otherCaveName.equals("start"))) {
                    if (cave.isOneVisit()) {
                        if (!cave.isVisited()) {
                            cave.setVisited(true);
                            caves.set(caveIndex, cave);
                            nrOfPaths = nrOfPaths + backtracking(paths, caves, otherCaveName, twice);
                            cave.setVisited(false);
                            caves.set(caveIndex, cave);
                        }
                        else {
                            nrOfPaths = nrOfPaths + backtracking(paths, caves, otherCaveName, !twice);
                        }
                    }
                    else {
                        nrOfPaths = nrOfPaths + backtracking(paths, caves, otherCaveName, twice);
                    }
                }
            }
        }
        return nrOfPaths;
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<Paths> paths = reader.readEdges("resources/day12.txt");
        List<Cave> caves = generateCaveList(paths);
        int startIndex = findCaveIndex(caves, "start");
        Cave startCave = caves.get(startIndex);
        startCave.setVisited(true);
        caves.set(startIndex, startCave);
        System.out.println(backtracking(paths, caves, "start", true));
    }
}
