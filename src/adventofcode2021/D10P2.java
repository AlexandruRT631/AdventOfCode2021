package adventofcode2021;

import java.io.IOException;
import java.util.*;

public class D10P2 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> lines = reader.readFromInput("resources/day10.txt");

        List<Long> scores = new ArrayList<>();
        for (String line : lines) {
            Stack<String> parenthesisStack = new Stack<String>();
            boolean ok = true;
            for (int i = 0; i < line.length() && ok; i++) {
                String parenthesis = String.valueOf(line.charAt(i));
                if (parenthesis.equals("(") || parenthesis.equals("[") || parenthesis.equals("{") || parenthesis.equals("<")) {
                    parenthesisStack.push(parenthesis);
                }
                else {
                    String aux = parenthesisStack.pop();
                    if ((aux.equals("(") && !parenthesis.equals(")")) ||
                            (aux.equals("[") && !parenthesis.equals("]")) ||
                            (aux.equals("{") && !parenthesis.equals("}")) ||
                            (aux.equals("<") && !parenthesis.equals(">"))) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                long score = 0;
                while (!parenthesisStack.isEmpty()) {
                    String parenthesis = parenthesisStack.pop();
                    score = score * 5;
                    score = switch (parenthesis) {
                        case "(" -> score + 1;
                        case "[" -> score + 2;
                        case "{" -> score + 3;
                        case "<" -> score + 4;
                        default -> score;
                    };
                }
                scores.add(score);
            }
        }
        Collections.sort(scores);
        System.out.println(scores.get(scores.size() / 2));
    }
}
