package GFG.sorting;

import GFG.sorting.Utils.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(Interval.of(1, 3));
        intervals.add(Interval.of(2, 4));
        intervals.add(Interval.of(5, 7));
        intervals.add(Interval.of(6, 8));

        intervals = mergeIntervals(intervals);
        System.out.println(intervals);

        intervals = new ArrayList<>();
        intervals.add(Interval.of(7,9 ));
        intervals.add(Interval.of(6, 10));
        intervals.add(Interval.of(4,5 ));
        intervals.add(Interval.of(1,3 ));
        intervals.add(Interval.of(2,4 ));

        intervals = mergeIntervals(intervals);
        System.out.println(intervals);
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>(intervals.size());
        intervals.sort(Comparator.comparing(Interval::getX));
        list.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            if(validate(list.get(list.size() - 1), intervals.get(i))) {
                merge(list.get(list.size() - 1), intervals.get(i));
            } else
                list.add(intervals.get(i));
        }

        return list;
    }

    private static void merge(Interval i1, Interval i2) {
        i1.x = Math.min(i1.x, i2.x);
        i1.y = Math.max(i1.y, i2.y);
    }

    private static boolean validate(Interval i1, Interval i2) {
        return i1.y >= i2.x;
    }


}
