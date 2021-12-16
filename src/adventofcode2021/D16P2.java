package adventofcode2021;

import java.io.IOException;

public class D16P2 implements PuzzleBasics {
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

    public long packet(String input) {
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
            return Long.parseLong(binaryRepresent, 2);
//            System.out.println("Literal value: " + Long.parseLong(binaryRepresent, 2));
        } else {
            int lengthTypeId = Integer.parseInt(getGroupOf(input, 1));
//            System.out.println("TypeID: " + lengthTypeId);
            if (lengthTypeId == 0) {
                String binaryRepresent = getGroupOf(input, 15);
                int originalCharIndex = charIndex;
                int originalStartIndex = startIndex;
                advance(Integer.parseInt(binaryRepresent, 2));
                int finalCharIndex = charIndex;
                charIndex = originalCharIndex;
                int finalStartIndex = startIndex;
                startIndex = originalStartIndex;
                int output = 0;
                switch (typeID) {
                    case 0:
                        long sum = 0;
                        while (charIndex < finalCharIndex || (charIndex == finalCharIndex && startIndex < finalStartIndex)){
                            sum = sum + packet(input);
                        }
                        return sum;
                    case 1:
                        long product = 1;
                        while (charIndex < finalCharIndex || (charIndex == finalCharIndex && startIndex < finalStartIndex)){
                            product = product * packet(input);
                        }
                        return product;
                    case 2:
                        long min = packet(input);
                        while (charIndex < finalCharIndex || (charIndex == finalCharIndex && startIndex < finalStartIndex)){
                            min = Math.min(min, packet(input));
                        }
                        return min;
                    case 3:
                        long max = packet(input);
                        while (charIndex < finalCharIndex || (charIndex == finalCharIndex && startIndex < finalStartIndex)){
                            max = Math.max(max, packet(input));
                        }
                        return max;
                    case 5:
                        if (packet(input) > packet(input)) {
                            output = 1;
                        }
                        charIndex = finalCharIndex;
                        startIndex = finalStartIndex;
                        return output;
                    case 6:
                        if (packet(input) < packet(input)) {
                            output = 1;
                        }
                        charIndex = finalCharIndex;
                        startIndex = finalStartIndex;
                        return output;
                    case 7:
                        if (packet(input) == packet(input)) {
                            output = 1;
                        }
                        charIndex = finalCharIndex;
                        startIndex = finalStartIndex;
                        return output;
                }
            } else {
                String binaryRepresent = getGroupOf(input, 11);
                int nrOfPackets = Integer.parseInt(binaryRepresent, 2);
                int output = 0;
                switch (typeID) {
                    case 0:
                        long sum = 0;
                        while (nrOfPackets != 0) {
                            sum = sum + packet(input);
                            nrOfPackets--;
                        }
                        return sum;
                    case 1:
                        long product = 1;
                        while (nrOfPackets != 0) {
                            product = product * packet(input);
                            nrOfPackets--;
                        }
                        return product;
                    case 2:
                        long min = packet(input);
                        nrOfPackets--;
                        while (nrOfPackets != 0) {
                            min = Math.min(min, packet(input));
                            nrOfPackets--;
                        }
                        return min;
                    case 3:
                        long max = packet(input);
                        nrOfPackets--;
                        while (nrOfPackets != 0) {
                            max = Math.max(max, packet(input));
                            nrOfPackets--;
                        }
                        return max;
                    case 5:
                        if (packet(input) > packet(input)) {
                            output = 1;
                        }
                        nrOfPackets -=2;
                        while (nrOfPackets != 0) {
                            packet(input);
                            nrOfPackets--;
                        }
                        return output;
                    case 6:
                        if (packet(input) < packet(input)) {
                            output = 1;
                        }
                        nrOfPackets -=2;
                        while (nrOfPackets != 0) {
                            packet(input);
                            nrOfPackets--;
                        }
                        return output;
                    case 7:
                        if (packet(input) == packet(input)) {
                            output = 1;
                        }
                        nrOfPackets -=2;
                        while (nrOfPackets != 0) {
                            packet(input);
                            nrOfPackets--;
                        }
                        return output;
                }
            }
        }
        return 0;
    }

    @Override
    public void run() throws IOException {
        Reader reader = new Reader();
        String input = reader.readFirstLine("resources/day16.txt");
        System.out.println(packet(input));
    }
}
