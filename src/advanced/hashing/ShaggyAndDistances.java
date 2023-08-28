package advanced.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShaggyAndDistances {

    public class Pair {
        int idx;
        int dist;
        public Pair(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    public int solve(ArrayList<Integer> A) {
        int n = A.size();

        HashMap<Integer, Pair> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            Pair cur;
            if(hm.containsKey(A.get(i))) {
                cur = hm.get(A.get(i));
                cur.dist = Math.min(cur.dist, Math.abs(i - cur.idx));
                cur.idx = i;
            } else {
                cur = new Pair(i, Integer.MAX_VALUE);
            }
            hm.put(A.get(i), cur);
        }

        int minDist = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Pair> entry : hm.entrySet()) {
            minDist = Math.min(minDist, entry.getValue().dist);
        }

        if(minDist == Integer.MAX_VALUE) return -1;
        return minDist;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(7, 1, 3, 4, 1, 7));
        System.out.println(new ShaggyAndDistances().solve(ls));
    }

}
