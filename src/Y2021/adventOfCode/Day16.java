package Y2021.adventOfCode;

import Y2021.adventOfCode.input.DataReader;

import java.util.HashMap;
import java.util.Map;

public class Day16 {

    private static Map<Character , String> map = init();


    private static int versionSum = 0;

    public static void main(String[] args) throws Exception {
        String input = DataReader.readInput("/day16.txt").get(0);
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(map.get(c));
        }
        input = sb.toString();
        System.out.println("input " + input);

        processPackets(input, 0, input.length());

        System.out.println("Version " + versionSum);


    }

    private static int processPackets(String packets, int start, int length) {

        if(start + 11 > length) {
            //System.out.println("Skipped " + (packets.length() - start) + " from " + start);
            return start;
        }
        int version = parseBinary(packets.substring(start, start += 3));
        versionSum += version;
        int type = parseBinary(packets.substring(start, start += 3));
        // Literal
        if(type == 4) {
            boolean isEnd = false;
            StringBuilder number = new StringBuilder();
            while (!isEnd) {
                isEnd = packets.charAt(start++) - 48 == 0;
                // this gives the value of this 4 bit but not used anywhere
                number.append(packets, start, start += 4);
            }
            //System.out.println(parseBinary(number.toString()));
            return start;
        } else {
            // length type 0
            int lengthType = packets.charAt(start++) - 48;
            if(lengthType == 0) {
                int len = parseBinary(packets.substring(start, start += 15));
                start = processPackets(packets, start, start + len);
            }
            // length type 1
            else {
                int loop = parseBinary(packets.substring(start, start += 11));
                for (int i = 0; i < loop; i++) {
                    start = processPackets(packets, start, packets.length());
                }
            }
        }
        return processPackets(packets, start, packets.length());
    }

    private static int parseBinary(String binary) {
        int bitValue = 1, result = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if((binary.charAt(i) - '0') == 1) {
                result += bitValue;
            }
            bitValue *= 2;
        }
        return result;
    }


    private static Map<Character , String> init() {
        Map<Character , String> map = new HashMap<>();
        {
            map.put('0', "0000");
            map.put('1', "0001");
            map.put('2', "0010");
            map.put('3', "0011");
            map.put('4', "0100");
            map.put('5', "0101");
            map.put('6', "0110");
            map.put('7', "0111");
            map.put('8', "1000");
            map.put('9', "1001");
            map.put('A', "1010");
            map.put('B', "1011");
            map.put('C', "1100");
            map.put('D', "1101");
            map.put('E', "1110");
            map.put('F', "1111");
        }
        return map;
    }



}
