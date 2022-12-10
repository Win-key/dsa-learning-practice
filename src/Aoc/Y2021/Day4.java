package Aoc.Y2021;

import Aoc.input.DataReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Day4 {

    private static int lastWin = 0;

    public static void main(String[] args) throws Exception {
        List<String> input = DataReader.readInput("/day4.txt");
        Integer[] numbers = Arrays.stream(input.get(0).split(",")).map(Integer::valueOf).toArray(Integer[]::new);
        List<Integer[][]> boards = new ArrayList<>();
        List<Integer[][]> boards2 = new ArrayList<>();
        for (int i = 2; i < input.size(); i++) {
            Integer[][] board = new Integer[5][5];
            Integer[][] board2 = new Integer[5][5];
            for (int j = i; j < i + 5; j++) {
                board[j - i] = Arrays.stream(input.get(j).split(" ")).filter(Predicate.not(String::isBlank)).map(Integer::valueOf).toArray(Integer[]::new);
                board2[j - i] = Arrays.stream(input.get(j).split(" ")).filter(Predicate.not(String::isBlank)).map(Integer::valueOf).toArray(Integer[]::new);
            }
            boards.add(board);
            boards2.add(board2);
            i = (i + 5);
        }
        partA(numbers, boards);
        partB(numbers, boards2);
        System.out.println("lastWin : " + lastWin);
    }

    private static void partA(Integer[] nums, List<Integer[][]> boards) {
        for (int i = 0; i < nums.length; i++) {
            if (markNumberOnBoards(nums[i], boards))
                break;
        }
    }

    private static boolean markNumberOnBoards(Integer num, List<Integer[][]> boards) {
        for (Integer[][] board : boards) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (num.equals(board[i][j])) {
                        board[i][j] = -1;
                        boolean isFilled = isRowColFilled(board, i, j);
                        if (isFilled) {
                            calcScore(num, board);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int calcScore(Integer num, Integer[][] board) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != -1)
                    sum += board[i][j];
            }
        }
        System.out.println(sum * num);
        return sum * num;
    }

    private static boolean isRowColFilled(Integer[][] board, int i, int j) {
        boolean flag1 = true, flag2 = true;
        for (int k = 0; k < 5; k++) {
            if (board[i][k] != -1) {
                flag1 = false;
                break;
            }
        }
        for (int k = 0; k < 5; k++) {
            if (board[k][j] != -1) {
                flag2 = false;
                break;
            }
        }

        return flag1 || flag2;
    }

    private static void partB(Integer[] nums, List<Integer[][]> boards) {
        for (Integer num : nums) {
            if (!boards.isEmpty()) {
                markNumberOnBoardsB(num, boards);
            }
        }
    }

    private static void markNumberOnBoardsB(Integer num, List<Integer[][]> boards) {
        Iterator<Integer[][]> itr = boards.iterator();
        while (itr.hasNext()) {
            var board = itr.next();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (num.equals(board[i][j])) {
                        board[i][j] = -1;
                        boolean isFilled = isRowColFilled(board, i, j);
                        if (isFilled) {
                            lastWin = calcScore(num, board);
                            itr.remove();
                        }
                    }
                }
            }
        }
    }

}
