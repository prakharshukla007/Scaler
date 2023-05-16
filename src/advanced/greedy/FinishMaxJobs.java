package advanced.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FinishMaxJobs {

    public class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 1;

        ArrayList<Pair> pairList = new ArrayList<>();
        for(int i=0; i<A.size(); i++) {
            pairList.add(new Pair(A.get(i), B.get(i)));
        }
        Collections.sort(pairList, Comparator.comparingInt(a -> a.y));

        int lastEnd = pairList.get(0).y;
        for(int i=1; i<pairList.size(); i++) {
            if(pairList.get(i).x >= lastEnd) {
                lastEnd = pairList.get(i).y;
                ans++;
            }
        }

        return ans;
    }

}
