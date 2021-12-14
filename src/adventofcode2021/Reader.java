package adventofcode2021;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public List<String> readFromInput(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        return lines;
    }

    public List<String> readDrawnNumbers(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        List<String> drawnNumbers = Arrays.asList(lines.get(0).split(","));
        return drawnNumbers;
    }

    public List<BingoBoard> readBingoBoards(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        List<BingoBoard> bingoBoards = new ArrayList<BingoBoard>();
        for (int i = 2; i < lines.size(); i += 6) {
            BingoBoard board = new BingoBoard();
            for (int j = 0; j < 5; j++) {
                board.setBingoBoardRow(lines.get(i + j), j);
            }
            bingoBoards.add(board);
        }
        return bingoBoards;
    }

    public List<LineCoordinates> readCoordinates(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        List<LineCoordinates> lineCoordinates = new ArrayList<>();
        for (String line : lines) {
            int[] coordinates = Arrays.stream(line.replaceAll("[^0-9,]", ",").split(",+")).mapToInt(Integer::parseInt).toArray();
            LineCoordinates coordinates1 = new LineCoordinates(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
            lineCoordinates.add(coordinates1);
        }
        return lineCoordinates;
    }

    public int[][] readMap(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        int[][] map = new int[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        return map;
    }

    public MapCoordinate[][] readMapCoordinate(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        MapCoordinate[][] map = new MapCoordinate[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = new MapCoordinate(line.charAt(j) - '0');
            }
        }
        return map;
    }

    public List<Paths> readEdges(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        List<Paths> paths = new ArrayList<>();
        for (String line : lines) {
            String[] node = line.split("-");
            paths.add(new Paths(node[0], node[1]));
        }
        return paths;
    }

    public boolean[][] readPaper(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        int xMax = 0;
        int yMax = 0;
        for (int i = 0; i < lines.size() && !lines.get(i).equals(""); i++) {
            String[] coordinates = lines.get(i).split(",");
            if (Integer.parseInt(coordinates[1]) > xMax) {
                xMax = Integer.parseInt(coordinates[1]);
            }
            if (Integer.parseInt(coordinates[0]) > yMax) {
                yMax = Integer.parseInt(coordinates[0]);
            }
        }
        xMax++;
        yMax++;
        boolean[][] paper = new boolean[xMax][yMax];
        for (int i = 0; i < lines.size() && !lines.get(i).equals(""); i++) {
            String[] coordinates = lines.get(i).split(",");
            paper[Integer.parseInt(coordinates[1])][Integer.parseInt(coordinates[0])] = true;
        }
        return paper;
    }

    public List<Fold> readFoldings(String filename) throws IOException {
        List<Fold> folds = new ArrayList<>();
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        int i = 0;
        while (!lines.get(i).equals("")) {
            i++;
        }
        i++;
        while (i < lines.size()) {
            String[] importantValues = lines.get(i).split(" ")[2].split("=");
            int axis = Integer.parseInt(importantValues[1]);
            boolean vertical = importantValues[0].equals("x");
            Fold fold = new Fold(axis, vertical);
            folds.add(fold);
            i++;
        }
        return folds;
    }

    public String readFirstLine(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        return lines.get(0);
    }

    public char[] readHashMap(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        List<String> lines = Files.readAllLines(levelFile);
        char[] hashMap = new char[675];
        for (int i = 2; i < lines.size(); i++) {
            String[] values = lines.get(i).split(" -> ");
            hashMap[(values[0].charAt(0) - 'A') * 26 + values[0].charAt(1) - 'A'] = values[1].charAt(0);
        }
        return hashMap;
    }
}