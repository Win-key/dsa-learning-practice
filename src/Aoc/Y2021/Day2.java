package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String[] args) throws Exception {
        Submarine submarine = new Submarine();
        List<Action> actionStream = DataReader.readInput("/day2.txt")
                .stream()
                .map(Action::build)
                .collect(Collectors.toList());
        actionStream.forEach(submarine::drive);
        submarine.states();

        submarine = new Submarine();
        actionStream.forEach(submarine::driveB);
        submarine.states();
    }

    static class Action {
        private String action;
        private int value;

        private Action(String action, int value) {
            this.action = action;
            this.value = value;
        }
        public static Action build(String actionValue) {
            String[] actionValueAr = actionValue.split(" ");
            return new Action(actionValueAr[0],Integer.parseInt(actionValueAr[1]));
        }

        @Override
        public String toString() {
            return "action='" + action + '\'' +
                    ", value=" + value;
        }
    }

    static class Submarine {
        private int distance;
        private int depth;
        private int aim;

        public void drive(Action action) {
            System.out.println("Driving: " + action.toString());
            switch (action.action) {
                case "forward" :
                    forward(action.value);
                    break;
                case "down":
                    down(action.value);
                    break;
                case "up":
                    up(action.value);
                    break;
                default:
                    throw new IllegalArgumentException("No action found :" + action.action);
            }
        }

        public void driveB(Action action) {
            System.out.println("Driving: " + action.toString());
            switch (action.action) {
                case "forward" :
                    forward(action.value);
                    this.depth += (action.value * aim);
                    break;
                case "down":
                    aim(action.value);
                    break;
                case "up":
                    aim(-1*action.value);
                    break;
                default:
                    throw new IllegalArgumentException("No action found :" + action.action);
            }
        }

        private void forward(int X) {
            this.distance += X;
        }

        private void aim(int X) {
            this.aim += X;
        }

        private void down(int Y) {
            this.depth += Y;
        }
        private void up(int Y) {
            this.depth -= Y;
        }

        @Override
        public String toString() {
            return "Submarine{" +
                    "distance=" + distance +
                    ", depth=" + depth +
                    '}';
        }

        public void states() {
            System.out.println(this + "\nmul : " + (distance*depth));
        }
    }
}
