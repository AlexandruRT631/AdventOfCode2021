package adventofcode2021;

import java.util.List;

public class Paths {
    private String a;
    private String b;

    public Paths(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public boolean hasCave(String cave) {
        return a.equals(cave) || b.equals(cave);
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }
}
