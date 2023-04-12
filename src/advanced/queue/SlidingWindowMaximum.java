package advanced.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] slidingMaximum(final int[] A, int B) {
        int n = A.length;
        int start = 0;
        int[] ans = new int[n-B+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<B; i++) {
            while(!deque.isEmpty() && A[deque.peekLast()] < A[i]) deque.pollLast();
            deque.addLast(i);
        }
        start++;
        int idx = 0;
        ans[idx++] = A[deque.peekFirst()];
        for(int i=B; i<n; i++) {
            while(!deque.isEmpty() && A[deque.peekLast()] < A[i]) deque.pollLast();
            deque.addLast(i);
            if(start > deque.peekFirst()) deque.pollFirst();
            ans[idx++] = A[deque.peekFirst()];
            start++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] res = new SlidingWindowMaximum().slidingMaximum(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for(int n : res) System.out.print(n + " ");
    }

}
