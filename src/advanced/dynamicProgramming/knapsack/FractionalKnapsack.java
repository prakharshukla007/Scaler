package advanced.dynamicProgramming.knapsack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    public class Pair {
        int v;
        int w;
        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return (int) ((1000 * (o2.v/(double)o2.w)) - (1000 * (o1.v/(double)o1.w)));
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Pair> pairList = new ArrayList<>();
        int n = A.size();
        for(int i=0; i<n; i++) pairList.add(new Pair(A.get(i), B.get(i)));
        pairList.sort(new PairComparator());

        int curWt = 0;
        int idx = 0;
        double ans = 0;
        while(idx < n && curWt < C) {
            if(curWt + pairList.get(idx).w <= C) {
                curWt += pairList.get(idx).w;
                ans += pairList.get(idx).v;
            }
            else {
                int leftCapacity = C - curWt;
                ans += (pairList.get(idx).v/(double)pairList.get(idx).w) * leftCapacity;
                return (BigDecimal.valueOf(ans).multiply(BigDecimal.valueOf(100))).intValue();
            }
            idx++;
        }

        return (int) (ans * 100);
    }

    public static void main(String[] args) {
        System.out.println(new FractionalKnapsack().solve(new ArrayList<>(List.of(60, 100, 120)), new ArrayList<>(List.of(10, 20, 30)), 50));
    }

}
