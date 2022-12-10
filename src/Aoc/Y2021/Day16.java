package Aoc.Y2021;

import Aoc.input.DataReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16 {

    private static Map<Character, String> map = init();

    private static int versionSum = 0;
    private static int index = 0;
    private static String input;

    public static void main(String[] args) throws Exception {
        String input = DataReader.readInput("/day16.txt").get(0);
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(map.get(c));
        }
        input = sb.toString();
        System.out.println("input " + input);
        Day16.input = input;

        Packet packet = buildPackets();

        System.out.println("Part A : Version " + versionSum);
        System.out.println("Part B : Evaluation " +packet.evaluate());


    }
    public static Packet buildPackets() {
        int version = Integer.parseInt(input.substring(index, index += 3), 2);
        versionSum += version;
        int type = Integer.parseInt(input.substring(index, index += 3), 2);
        if(type == 4) {
            return LiteralPacket.build(version, type);
        } else {
            return OperatorPacket.build(version, type, buildSubPackets());
        }
    }

    public static List<Packet> buildSubPackets() {
        List<Packet> list = new ArrayList<>();
        int lengthType = input.charAt(index++) - 48;

        if (lengthType == 0) {
            int len = Integer.parseInt(input.substring(index, index += 15), 2);
            len += index;
            while (index < len) {
                list.add(buildPackets());
            }
        } else {
            int loop = Integer.parseInt(input.substring(index, index += 11), 2);
            for (int i = 0; i < loop; i++) {
                list.add(buildPackets());
            }
        }
        return list;
    }

    static abstract class Packet {
        int version;
        int type;

        public Packet(int version, int type) {
            this.version = version;
            this.type = type;
        }

        public abstract long evaluate();
    }

    static class LiteralPacket extends Packet {
        long value;

        public LiteralPacket(int version, int type, long value) {
            super(version, type);
            this.value = value;
        }

        @Override
        public long evaluate() {
            return value;
        }

        public static Packet build( int version, int type) {
            boolean isEnd = false;
            StringBuilder number = new StringBuilder();
            while (!isEnd) {
                isEnd = input.charAt(index++) - 48 == 0;
                number.append(input, index, index += 4);
            }
            return new LiteralPacket(version, type, Long.parseLong(number.toString(), 2));
        }
    }

    static class OperatorPacket extends Packet {
        List<Packet> subPackets;

        public OperatorPacket(int version, int type, List<Packet> subPackets) {
            super(version, type);
            this.subPackets = subPackets;
        }

        @Override
        public long evaluate() {
            switch (type) {
                case 0:
                    return subPackets.stream().mapToLong(Packet::evaluate).sum();
                case 1:
                    return subPackets.stream().mapToLong(Packet::evaluate).reduce(Math::multiplyExact).getAsLong();
                case 2:
                    return subPackets.stream().mapToLong(Packet::evaluate).min().getAsLong();
                case 3:
                    return subPackets.stream().mapToLong(Packet::evaluate).max().getAsLong();
                case 5:
                    return subPackets.get(0).evaluate() > subPackets.get(1).evaluate() ? 1L : 0L;
                case 6:
                    return subPackets.get(0).evaluate() < subPackets.get(1).evaluate() ? 1L : 0L;
                case 7:
                    return subPackets.get(0).evaluate() == subPackets.get(1).evaluate() ? 1L : 0L;
            }
            return 0L;
        }

        public static Packet build(int version, int type, List<Packet> subPackets) {
            return new OperatorPacket(version, type, subPackets);
        }
    }

    private static Map<Character, String> init() {
        Map<Character, String> map = new HashMap<>();
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











    private static int processPackets(String packets, int start, int length) {

        if (start + 11 > length) {
            //System.out.println("Skipped " + (packets.length() - start) + " from " + start);
            return start;
        }
        int version = Integer.parseInt(packets.substring(start, start += 3), 2);
        versionSum += version;
        int type = Integer.parseInt(packets.substring(start, start += 3), 2);
        if (type == 4) {
            boolean isEnd = false;
            while (!isEnd) {
                isEnd = packets.charAt(start++) - 48 == 0;
                start += 4;
            }
            return start;
        } else {
            int lengthType = packets.charAt(start++) - 48;
            if (lengthType == 0) {
                int len = Integer.parseInt(packets.substring(start, start += 15), 2);
                while (start < len) {
                    start = processPackets(packets, start, start + len);
                }
            }
            else {
                int loop = Integer.parseInt(packets.substring(start, start += 11), 2);
                for (int i = 0; i < loop; i++) {
                    start = processPackets(packets, start, packets.length());
                }
            }
        }
        return processPackets(packets, start, packets.length());
    }

}
