package adventofcode2021;

import java.io.IOException;

public class D16P1 implements PuzzleBasics {
    private int charIndex = 0;
    private int startIndex = 0;
    private int version = 0;

    public String getGroupOf5(String input, int charIndex, int startIndex) {
        char[] group = new char[5];
        String hexValue = String.valueOf(input.charAt(charIndex)) + String.valueOf(input.charAt(charIndex + 1));
        int decimalValue = Integer.parseInt(hexValue, 16);
        char[] binaryValue = String.format("%8s", Integer.toBinaryString(decimalValue)).replace(" ", "0").toCharArray();
        System.arraycopy(binaryValue, startIndex, group, 0, 5);
        return String.valueOf(group);
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String input = reader.readFirstLine("resources/day16.txt");
        version = version + Integer.parseInt(String.valueOf(input.charAt(0)), 16) / 2;
        int typeID = 4 * (Integer.parseInt(String.valueOf(input.charAt(0)), 16) % 2) + Integer.parseInt(String.valueOf(input.charAt(1)), 16) / 4;
        if (typeID == 4) {
            String binaryRepresent = "";
            charIndex = charIndex + 1;
            startIndex = startIndex + 2;
            if (startIndex >= 4) {
                startIndex = startIndex - 4;
                charIndex++;
            }
            String group = getGroupOf5(input, charIndex, startIndex);
            while (group.charAt(0) == '1') {
                binaryRepresent = binaryRepresent + group.substring(1, 5);
                charIndex++;
                startIndex++;
                if (startIndex == 4) {
                    startIndex = 0;
                    charIndex++;
                }
                group = getGroupOf5(input, charIndex, startIndex);
            }
            binaryRepresent = binaryRepresent + group.substring(1, 5);
            System.out.println(Integer.parseInt(binaryRepresent, 2));
        }
        else {
            int lengthTypeId = Integer.parseInt(String.valueOf(input.charAt(1)), 16) / 2 % 2;
            System.out.println(lengthTypeId);
            if (lengthTypeId == 0) {

            }
            else {

            }
        }
        System.out.println();
    }
}
