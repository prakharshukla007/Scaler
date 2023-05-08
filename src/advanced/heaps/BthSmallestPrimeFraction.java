package advanced.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Double.compare(p1.x/(double)p1.y, p2.x/(double)p2.y);
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> pQ = new PriorityQueue<>(new PairComparator());
        int n = A.size();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                pQ.add(new Pair(A.get(i), A.get(j)));
            }
        }

        Pair ansPair = null;
        while(B > 0) {
            B--;
            ansPair = pQ.poll();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ansPair.x);
        ans.add(ansPair.y);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(1, 7));
        System.out.println(new BthSmallestPrimeFraction().solve(ls, 1));
    }

}
