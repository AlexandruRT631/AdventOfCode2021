package adventofcode2021;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class D10P1 implements PuzzleBasics {
    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        List<String> lines = reader.readFromInput("resources/day10.txt");

        int errorPoints = 0;
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
                        switch (parenthesis) {
                            case ")" -> errorPoints = errorPoints + 3;
                            case "]" -> errorPoints = errorPoints + 57;
                            case "}" -> errorPoints = errorPoints + 1197;
                            case ">" -> errorPoints = errorPoints + 25137;
                        }
                    }

                }
            }
        }
        System.out.println(errorPoints);
    }
}
