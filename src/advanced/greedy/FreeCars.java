package advanced.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            pairList.add(new Pair(A.get(i), B.get(i)));
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < B.size(); i++) minHeap.add(B.get(i));

        Collections.sort(pairList, Comparator.comparingInt(a -> a.x));
        int t = 0;
        int totalProfit = 0;
        for (int i = 0; i < pairList.size(); i++) {
            if(t > pairList.get(i).x) {
                if (!minHeap.isEmpty() && pairList.get(i).y > minHeap.peek()) {
                    int b = minHeap.poll();
                    totalProfit -= b;
                    totalProfit += pairList.get(i).y;
                    minHeap.add(pairList.get(i).y);
                }
            }
            else {
                t++;
                totalProfit += pairList.get(i).y;
                minHeap.add(pairList.get(i).y);
            }
        }

        return totalProfit;
    }

}
