package adventofcode2021;

public class Polymer {
    private char startLetter;
    private char endLetter;
    private char[] hashMap;
    private int[] hashFreq = new int[675];

    private int getHashValue(String hash) {
        return (hash.charAt(0) - 'A') * 26 + hash.charAt(1) - 'A';
    }

    public Polymer(String polymer, char[] hashMap) {
        startLetter = polymer.charAt(0);
        endLetter = polymer.charAt(polymer.length() - 1);
        this.hashMap = hashMap;
        for (int i = 1; i < polymer.length(); i++) {
            char[] aux = new char[2];
            aux[0] = polymer.charAt(i - 1);
            aux[1] = polymer.charAt(i);
            String hash = String.valueOf(aux);
            hashFreq[getHashValue(hash)]++;
        }
    }

    private char getHashCorespondent(String hash) {
        return hashMap[getHashValue(hash)];
    }

    private String getHash(int i) {
        char[] hash = new char[2];
        hash[0] = (char)(i / 26 + 'A');
        hash[1] = (char)(i % 26 + 'A');
        return String.valueOf(hash);
    }

    public void nextStep() {
        int[] oldHashFreq = new int[675];
        System.arraycopy(hashFreq, 0, oldHashFreq, 0, 675);
        for (int i = 0; i < 675; i++) {
            if (oldHashFreq[i] > 0) {
                hashFreq[i] = hashFreq[i] - oldHashFreq[i];
                String hash = getHash(i);
                char newValue = getHashCorespondent(hash);
                char[] aux = new char[2];
                aux[0] = hash.charAt(0);
                aux[1] = newValue;
                hashFreq[getHashValue(String.valueOf(aux))] = hashFreq[getHashValue(String.valueOf(aux))] + oldHashFreq[i];
                aux[0] = newValue;
                aux[1] = hash.charAt(1);
                hashFreq[getHashValue(String.valueOf(aux))] = hashFreq[getHashValue(String.valueOf(aux))] + oldHashFreq[i];
            }
        }
    }

    public int difMcLcElem() {
        int[] element = new int[26];
        int min = 0, max = 0;
        for (int i = 0; i < 675; i++) {
            if (hashFreq[i] > 0) {
                String hash = getHash(i);
                element[hash.charAt(0) - 'A'] = element[hash.charAt(0) - 'A'] + hashFreq[i];
                element[hash.charAt(1) - 'A'] = element[hash.charAt(1) - 'A'] + hashFreq[i];
            }
        }
        for (int i = 1; i < 26; i++) {
            if (element[i] != 0) {
                if (min == 0) {
                    min = element[i];
                    max = element[i];
                }
                if (element[i] < min) {
                    min = element[i];
                }
                if (element[i] > max) {
                    max = element[i];
                }
            }
        }
        if (element[startLetter - 'A'] == min || element[endLetter - 'A'] == min) {
            min++;
        }
        if (element[startLetter - 'A'] == max || element[endLetter - 'A'] == max) {
            max++;
        }
        return (max - min) / 2;
    }
}
