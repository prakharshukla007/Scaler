package advanced.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergingIntervals {

    public static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        };

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        for(int i=0; i<n; i++) {
            Interval interval = intervals.get(i);
            if(interval.end >= newInterval.start && interval.start <= newInterval.end) {
                intervals.remove(i);
                intervals.add(i, new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end)));
            }
        }
        intervals = mergeIntervals(intervals);
        return intervals;
    }

    public static ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        ArrayList<Interval> result = new ArrayList<>();
        int length = intervals.size();
        for(int i=0; i<length; i++){
            Interval current = intervals.get(i);
            if(current.end < newInterval.start){
                result.add(current);
            }else if(current.start > newInterval.end){
                result.add(newInterval);
                while(i < length){
                    current = intervals.get(i);
                    result.add(current);
                    i++;
                }
                return result;
            }else{
                int newStart = Math.min(current.start, newInterval.start);
                int newEnd = Math.max(current.end, newInterval.end);
                newInterval = new Interval(newStart, newEnd);
            }

        }
        result.add(newInterval);
        return result;
    }

    public static class StartComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start < o2.start) return -1;
            else if(o1.start > o2.start) return 1;
            return 0;
        }
    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new StartComparator());
        int n = intervals.size();
        int[] s = new int[n];
        int[] e = new int[n];

        for(int i=0; i<n; i++) {
            s[i] = intervals.get(i).start;
            e[i] = intervals.get(i).end;
        }

        int L = s[0];
        int R = e[0];

        ArrayList<Interval> res = new ArrayList<>();
        for(int i=1; i<n; i++) {
            if(s[i] <= R) R = Math.max(R, e[i]);
            else {
                res.add(new Interval(L, R));
                L = s[i];
                R = e[i];
            }
        }

        res.add(new Interval(L, R));
        return res;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 10);
        Interval interval2 = new Interval(2, 9);
        Interval interval3 = new Interval(3, 8);
        Interval interval4 = new Interval(4, 7);
        Interval interval5 = new Interval(5, 6);
        Interval interval6 = new Interval(6, 6);
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(interval2, interval1, interval3, interval4, interval5, interval6));
        System.out.println(insert(intervals, new Interval(10, 8)));
        System.out.println(mergeIntervals(intervals));
    }

}
