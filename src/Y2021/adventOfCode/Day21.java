package Y2021.adventOfCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day21 extends BaseClass {

    private Map<GameState, Result> memory = new HashMap<>();

    public static void main(String[] args) {
        new Day21().execute();
    }

    @Override
    public void execute() {
        int p1Pos = Integer.parseInt(input.get(0).substring(input.get(0).length() - 1));
        int p2Pos = Integer.parseInt(input.get(1).substring(input.get(1).length() - 1));

        partA(p1Pos, p2Pos);

        Result result = countWins(new GameState(p1Pos, 0, p2Pos, 0));

        System.out.println(result);
    }

    private void partA(int p1Pos, int p2Pos) {
        int p2Score = 0, p1Score = 0, rolls = 0;

        while (p1Score < 1000 && p2Score < 1000) {
            rolls += 3;
            int r;
            int dice = ((r = rolls % 100) == 0) ? 100 : r, idx = rolls / 3;
            int val = (dice * (dice + 1)) / 2 - ((dice - 3) * (dice - 2)) / 2;
            int t;
            if (idx % 2 == 1)
                p1Score += (p1Pos = (t = (p1Pos +val) % 10) == 0 ? 10 : t);
            else
                p2Score += (p2Pos = (t = (p2Pos + val) % 10) == 0 ? 10 : t);
        }

        System.out.println(rolls + ": " + p1Score + " : " + p2Score);
        System.out.println(rolls * Math.min(p1Score, p2Score));
    }

    private Result countWins(GameState gameState) {
        if (gameState.p1Score >= 21) {
            return new Result(1, 0);
        } else if (gameState.p2Score >= 21) {
            return new Result(0, 1);
        } else if (memory.containsKey(gameState)) {
            return memory.get(gameState);
        }
        Result current = new Result(0, 0);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    int newPos = ((i + j + k + gameState.p1Pos - 1) % 10) + 1;
                    int newScore = gameState.p1Score + newPos;
                    Result newResult = countWins(new GameState(gameState.p2Pos, gameState.p2Score, newPos, newScore));
                    current.player1 += newResult.player2;
                    current.player2 += newResult.player1;
                }
            }
        }

        memory.put(gameState, current);

        return current;
    }

    static class GameState {
        private int p1Pos;
        private int p1Score;
        private int p2Pos;
        private int p2Score;

        public GameState(int p1Pos, int p1Score, int p2Pos, int p2Score) {
            this.p1Pos = p1Pos;
            this.p1Score = p1Score;
            this.p2Pos = p2Pos;
            this.p2Score = p2Score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GameState gameState = (GameState) o;
            return p1Pos == gameState.p1Pos && p1Score == gameState.p1Score && p2Pos == gameState.p2Pos && p2Score == gameState.p2Score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1Pos, p1Score, p2Pos, p2Score);
        }
    }

    static class Result {
        private long player1;
        private long player2;

        public Result(long player1, long player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        @Override
        public String toString() {
            return "player1 = " + player1 +
                    "\nplayer2 = " + player2 +
                    "\nWining score = " + Math.max(player1, player2);
        }
    }
}
