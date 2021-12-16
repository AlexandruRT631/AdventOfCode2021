package adventofcode2021;

import java.io.IOException;

public class D16P1 implements PuzzleBasics {
    private int charIndex = 0;
    private int startIndex = 0;
    private int version = 0;

    public void advance(int value) {
        startIndex = startIndex + value;
        charIndex = charIndex + startIndex / 4;
        startIndex = startIndex % 4;
    }

    public String getGroupOf(String input, int size) {
        char[] group = new char[size];
        char hexValue = input.charAt(charIndex);
        int decimalValue = Integer.parseInt(String.valueOf(hexValue), 16);
        char[] binaryValue = String.format("%4s", Integer.toBinaryString(decimalValue)).replace(" ", "0").toCharArray();
        for (int i = 0; i < size; i++) {
            if (startIndex == 0) {
                hexValue = input.charAt(charIndex);
                decimalValue = Integer.parseInt(String.valueOf(hexValue), 16);
                binaryValue = String.format("%4s", Integer.toBinaryString(decimalValue)).replace(" ", "0").toCharArray();
            }
            group[i] = binaryValue[startIndex];
            advance(1);
        }
        return String.valueOf(group);
    }

    public void packet(String input) {
        version = version + Integer.parseInt(getGroupOf(input, 3), 2);
        int typeID = Integer.parseInt(getGroupOf(input, 3), 2);
        if (typeID == 4) {
            String binaryRepresent = "";
            String group = getGroupOf(input,5);
            while (group.charAt(0) == '1') {
                binaryRepresent = binaryRepresent + group.substring(1, 5);
                group = getGroupOf(input, 5);
            }
            binaryRepresent = binaryRepresent + group.substring(1, 5);
            // this line will crash the code if binaryRepresentation is too big to be converter in integer
//            System.out.println("Literal value: " + Integer.parseInt(binaryRepresent, 2));
        } else {
            int lengthTypeId = Integer.parseInt(getGroupOf(input, 1));
            System.out.println("TypeID: " + lengthTypeId);
            if (lengthTypeId == 0) {
                String binaryRepresent = getGroupOf(input, 15);
                int originalCharIndex = charIndex;
                int originalStartIndex = startIndex;
                advance(Integer.parseInt(binaryRepresent, 2));
                int finalCharIndex = charIndex;
                charIndex = originalCharIndex;
                int finalStartIndex = startIndex;
                startIndex = originalStartIndex;
                while (charIndex < finalCharIndex || (charIndex == finalCharIndex && startIndex < finalStartIndex)){
                    packet(input);
                }
            } else {
                String binaryRepresent = getGroupOf(input, 11);
                int nrOfPackets = Integer.parseInt(binaryRepresent, 2);
                while (nrOfPackets != 0) {
                    packet(input);
                    nrOfPackets--;
                }
            }
        }
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String input = reader.readFirstLine("resources/day16.txt");
        packet(input);
        System.out.println(version);
    }
}
