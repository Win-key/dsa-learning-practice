package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Day12 {

    private static int paths = 0;

    public static void main(String[] args) throws Exception {
        Map<String, Node> nodeMap = new HashMap<>(Map.of("start", new Node("start"), "end", new Node("end")));
        List<String> input = DataReader.readInput("/day12.txt");
        for (String s : input) {
            String[] ar = s.split("-");
            for (String a : ar) {
                if (!nodeMap.containsKey(a)) {
                    nodeMap.put(a, new Node(a));
                }
            }
        }

        for (String s : input) {
            String[] ar = s.split("-");
            nodeMap.get(ar[0]).add(nodeMap.get(ar[1]));
            nodeMap.get(ar[1]).add(nodeMap.get(ar[0]));
        }

        countPaths(new Path(), nodeMap.get("start"));

        System.out.println(paths);
    }

    private static void countPaths(Path path, Node node) {
        Path newPath = new Path(path);

        if (node.isStart()) {
            if (newPath.addSmall(node.val)) {
                node.subNodes.forEach(n -> countPaths(newPath, n));
            }
        } else if (node.isSmall()) {
            if (newPath.addSmall(node.val)) {
                node.subNodes.forEach(n -> countPaths(newPath, n));
            }
            // only for Part B
            else if (!newPath.duplicateSmallCave) {
                newPath.duplicateSmallCave = true;
                newPath.add(node.val);
                node.subNodes.forEach(n -> countPaths(newPath, n));
            }
        } else if (node.isBig()) {
            newPath.add(node.val);
            node.subNodes.forEach(n -> countPaths(newPath, n));
        } else if (node.isEnd()) {
            newPath.add(node.val);
            paths++;
            System.out.println(newPath.path.toString());
        }
    }

    static class Path {
        Set<String> smallNodesVisited = new HashSet<>();
        List<String> path = new LinkedList<>();
        boolean duplicateSmallCave;

        public void add(String s) {
            path.add(s);
        }

        public Path(Path path) {
            if(Objects.nonNull(path)) {
                this.smallNodesVisited = new HashSet<>(path.smallNodesVisited);
                this.path = new LinkedList<>(path.path);
                this.duplicateSmallCave = path.duplicateSmallCave;
            }
        }

        public Path() {
        }

        public boolean addSmall(String val) {
            if (smallNodesVisited.add(val)) {
                path.add(val);
                return true;
            }
            return false;
        }

    }

    static class Node {
        private String val;

        private List<Node> subNodes = new ArrayList<>();

        public Node(String val) {
            this.val = val;
        }

        public void add(Node node) {
            this.subNodes.add(node);
        }

        public boolean isStart() {
            return val.equals("start");
        }

        public boolean isEnd() {
            return val.equals("end");
        }

        public boolean isBig() {
            return !isStart() && !isEnd() && val.equals(val.toUpperCase());
        }

        public boolean isSmall() {
            return !isStart() && !isEnd() && val.equals(val.toLowerCase());
        }
    }

}
