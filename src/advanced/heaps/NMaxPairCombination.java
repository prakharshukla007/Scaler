package advanced.heaps;

import java.util.*;

public class NMaxPairCombination {

    public class Pair {
        int val;
        int aidx;
        int bidx;
        public Pair(int val, int aidx, int bidx) {
            this.val = val;
            this.aidx = aidx;
            this.bidx = bidx;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pQ = new PriorityQueue<>((a, b) -> b.val - a.val);

        Set<String> hs = new HashSet<>();

        pQ.add(new Pair(A.get(A.size()-1) + B.get(B.size()-1), A.size()-1, B.size()-1));

        String str = (A.size()-1) + "@" + (B.size()-1);
        hs.add(str);

        for(int i=1; i<A.size(); i++) {
            Pair cur = pQ.poll();
            ans.add(cur.val);
            String str1 = (cur.aidx-1) + "@" + cur.bidx;
            String str2 = (cur.aidx) + "@" + (cur.bidx-1);

            int sum1 = A.get(cur.aidx-1) + B.get(cur.bidx);
            int sum2 = A.get(cur.aidx) + B.get(cur.bidx-1);

            Pair newPair1 = new Pair(sum1, cur.aidx-1, cur.bidx);
            Pair newPair2 = new Pair(sum2, cur.aidx, cur.bidx-1);

            if(!hs.contains(str1)) {
                pQ.add(newPair1);
                hs.add(str1);
            }
            if(!hs.contains(str2)) {
                pQ.add(newPair2);
                hs.add(str2);
            }
        }

        ans.add(pQ.peek().val);

        return ans;
    }

}
