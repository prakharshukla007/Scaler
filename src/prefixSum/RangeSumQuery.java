package prefixSum;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeSumQuery {

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(new Integer[] {7, 3, 1, 5, 5, 5, 1, 2, 4, 5}));
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        q.add(new ArrayList<>(Arrays.asList(new Integer[] {7, 10})));
        q.add(new ArrayList<>(Arrays.asList(new Integer[] {3, 10})));
        q.add(new ArrayList<>(Arrays.asList(new Integer[] {3, 5})));
        q.add(new ArrayList<>(Arrays.asList(new Integer[] {1, 10})));

        System.out.println(rangeSum(ls, q));
    }

    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> res = new ArrayList<>();
        Integer[] prefixSum = new Integer[A.size()];
        prefixSum[0] = A.get(0);
        for(int i=1; i<A.size(); i++) {
            prefixSum[i] = prefixSum[i-1] + A.get(i);
        }

        for(ArrayList<Integer> ls : B) {
            int l = ls.get(0);
            int r = ls.get(1);
            if(l == 1)
                res.add(prefixSum[r-1].longValue());
            else
                res.add(((Integer) (prefixSum[r-1] - prefixSum[l-2])).longValue());
        }

        return res;
    }

}
