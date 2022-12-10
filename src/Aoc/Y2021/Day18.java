package Aoc.Y2021;

import Aoc.input.BaseClass;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day18 extends BaseClass {

    private int index;
    private int magnitude;


    public static void main(String[] args) {
        Day18 day18 = new Day18();
        day18.execute();
    }

    @Override
    public void execute() {
        partAMagnitude();
        partBMaxMagnitude();
    }


    private void partBMaxMagnitude() {
        long maxMagnitude = Long.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                if(i != j) {
                    Number a = parse(input.get(i), null);
                    Number b = parse(input.get(j), null);
                    Number toBeProcessed = a.add(b);
                    toBeProcessed.explodeAndSplit(0);
                    maxMagnitude = Math.max(maxMagnitude, toBeProcessed.magnitude());
                }
            }
        }
        System.out.println("Part B : Max magnitude : " + maxMagnitude);
    }

    private void partAMagnitude() {
        List<Number> numbers = parseLines(input);
        Number result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = result.add(numbers.get(i));
            result.explodeAndSplit(0);
        }
        System.out.println("After process");
        System.out.println(result);
        System.out.println("Part A : Magnitude = " + result.magnitude());
    }

    private List<Number> parseLines(List<String> lines) {
        return lines.stream().map((s) -> this.parse(s, null)).collect(Collectors.toList());
    }

    private Number parse(String s, Number parent) {
        try{
            return new RegularNumber(Integer.parseInt(s), parent);
        } catch (Exception ignored) {}

        char c;
        int separator = -1;
        int depth = -1;
        int idx = 0;
        while (idx< s.length()) {
            c = s.charAt(idx);
            if(c == '[') {
                depth++;
            } else if(c == ']') {
                depth--;
            } else if(c == ',' && depth == 0) {
                separator = idx;
                break;
            }
            idx++;
        }
        PairNumber pairNumber = new PairNumber(null, null, parent);
        pairNumber.left = parse(s.substring(1, separator), pairNumber);
        pairNumber.right = parse(s.substring(separator+1, s.length() - 1), pairNumber);
        return pairNumber;
    }

    static interface Number {
        default void explodeAndSplit(int height) {
            boolean flag = true;
            while (flag) {
                flag = explode(height) || split();
            }
        }
        boolean split();
        boolean explode(int height);
        Number add(Number pairNumber);
        long magnitude();
    }

    static class RegularNumber implements Number{
        int val;
        Number parent;

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        public RegularNumber(int val, Number parent) {
            this.val = val;
            this.parent = parent;
        }

        @Override
        public boolean split() {
            if (val >= 10) {
                int dot = val / 2;
                PairNumber newPair = new PairNumber(null, null, this.parent);
                newPair.left = new RegularNumber(dot, newPair);
                newPair.right = new RegularNumber(val % 2 == 0 ? dot : dot + 1, newPair);
                // comparing object ref only
                if (((PairNumber) parent).left == this) {
                    ((PairNumber) parent).left = newPair;
                } else {
                    ((PairNumber) parent).right = newPair;
                }
                parent = null;
                return true;
            }
            return false;
        }

        @Override
        public boolean explode(int height) {
            return false;
        }

        @Override
        public Number add(Number pairNumber) {
            // do nothing
            return null;
        }

        @Override
        public long magnitude() {
            return val;
        }
    }

    static class PairNumber implements Number {
        Number left;
        Number right;
        Number parent;

        @Override
        public String toString() {
            return "["+ left + "," + right + "]";
        }

        public PairNumber(Number left, Number right, Number parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        // doubt full
        @Override
        public boolean split() {
            if(!left.split()) {
                return right.split();
            }
            return true;
        }

        @Override
        public boolean explode(int height) {
            boolean flag = false;
            if (height >= 4) {
                RegularNumber leftRegular = (RegularNumber) left;
                PairNumber currentParent = (PairNumber) parent;
                PairNumber pre = this;
                PairNumber toBeAdded = null;
                while (Objects.nonNull(currentParent)) {
                    if (currentParent.left instanceof RegularNumber) {
                        var target = (RegularNumber) currentParent.left;
                        target.val += leftRegular.val;
                        flag = true;
                        break;
                    } else if (currentParent.left != pre) {
                        toBeAdded = (PairNumber) currentParent.left;
                        break;
                    } else {
                        pre = currentParent;
                        currentParent = (PairNumber) currentParent.parent;
                    }
                }
                while (Objects.nonNull(toBeAdded)) {
                    if(toBeAdded.right instanceof RegularNumber) {
                        var target = (RegularNumber) toBeAdded.right;
                        target.val += leftRegular.val;
                        flag = true;
                        break;
                    }
                    toBeAdded = (PairNumber) toBeAdded.right;
                }

                RegularNumber rightRegular = (RegularNumber) right;


                currentParent = (PairNumber) parent;
                pre = this;
                toBeAdded = null;
                while (Objects.nonNull(currentParent)) {
                    if (currentParent.right instanceof RegularNumber) {
                        var target = (RegularNumber) currentParent.right;
                        target.val += rightRegular.val;
                        flag = true;
                        break;
                    } else if (currentParent.right != pre) {
                        toBeAdded = (PairNumber) currentParent.right;
                        break;
                    } else {
                        pre = currentParent;
                        currentParent = (PairNumber) currentParent.parent;
                    }
                }
                while (Objects.nonNull(toBeAdded)) {
                    if(toBeAdded.left instanceof RegularNumber) {
                        var target = (RegularNumber) toBeAdded.left;
                        target.val += rightRegular.val;
                        flag = true;
                        break;
                    }
                    toBeAdded = (PairNumber) toBeAdded.left;
                }

                if (((PairNumber) parent).left == this) {
                    ((PairNumber) parent).left = new RegularNumber(0, parent);
                } else {
                    ((PairNumber) parent).right = new RegularNumber(0, parent);
                }
            }
            return flag || this.left.explode(height + 1) || this.right.explode(height + 1);
        }

        @Override
        public Number add(Number pairNumber) {
            PairNumber newPair = new PairNumber(this, pairNumber , null);
            this.parent = newPair;
            ((PairNumber)pairNumber).parent = newPair;
            return newPair;
        }

        @Override
        public long magnitude() {
            return 3L * left.magnitude() + 2L * right.magnitude();
        }
    }

}
