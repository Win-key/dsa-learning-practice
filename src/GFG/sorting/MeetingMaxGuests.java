package GFG.sorting;

import GFG.sorting.Utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MeetingMaxGuests {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(Interval.of(900, 1000));
        intervals.add(Interval.of(940, 1030));
        solve(intervals);

        intervals = new ArrayList<>();
        intervals.add(Interval.of(800, 840));
        intervals.add(Interval.of(700, 820));
        intervals.add(Interval.of(600, 830));
        intervals.add(Interval.of(500, 530));
        solve(intervals);

        intervals = new ArrayList<>();
        intervals.add(Interval.of(900, 910));
        intervals.add(Interval.of(940, 1200));
        intervals.add(Interval.of(950, 1120));
        intervals.add(Interval.of(1100, 1130));
        intervals.add(Interval.of(1500, 1900));
        intervals.add(Interval.of(1800, 2000));
        solve(intervals);

        solveWithArrays(new int[] {900, 940, 950, 1100, 1500, 1800} , new int[] {910, 1200, 1120, 1130, 1900, 2000});

        solveWithArrays(new int[] {900, 940} , new int[] {1000, 1030});

    }

    public static void solve(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(Interval::getX));
        int x = intervals.get(0).x, y = intervals.get(0).y;
        int res = 1, count = 1;
        for (int i = 1; i < intervals.size(); i++) {
            Interval itrl = intervals.get(i);
            if(y >= itrl.x) {
                x = Math.max(x, itrl.x);
                y = Math.min(y, itrl.y);
                count++;
            } else {
                x = itrl.x; y = itrl.y;
                count = 1;
            }
            res = Math.max(count, res);
        }
        System.out.println("Maximum "+res + " guest can be met");
    }

    public static void solveWithArrays(int[] arrival, int[] departure) {
        // both are equal in size
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0, j = 0, count = 0, max = 0, n = arrival.length;
        while (i < n && j < n) {
            if(arrival[i] <= departure[j]) {
                count++; i++;
            } else {
                count--; j++;
            }
            max = Math.max(count, max);
        }

        System.out.println("Maximum "+max + " guest can be met");

    }
}
