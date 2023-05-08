package advanced.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumLargestNumber {

    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
        for (int i = 0; i < A.size(); i++)
            pq.add(new int[]{
                    A.get(i), A.get(i)
            });
        while (B > 0) {
            int[] poll = pq.poll();
            pq.add(new int[]{
                    poll[0] + poll[1], poll[1]
            });
            B--;
        }
        int max = Integer.MIN_VALUE;
        while (pq.size() != 0) max = Math.max(max, pq.poll()[0]);
        return max;
    }

}
