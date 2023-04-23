package advanced.queue;

import java.util.LinkedList;
import java.util.Queue;

public class IntegersWithOnly1or2or3 {

    public int[] solve(int A) {
        if(A <= 3) {
            int[] ans1 = new int[A];
            for(int i=0; i<A; i++) {
                ans1[i] = i+1;
            }
            return ans1;
        }
        int[] ans = new int[A];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        ans[idx++] = 1;
        queue.add(2);
        ans[idx++] = 2;
        queue.add(3);
        ans[idx++] = 3;
        for(int i=4; i<=A; i++) {
            int w = queue.poll();
            int x = 10 * w + 1;
            int y = 10 * w + 2;
            int z = 10 * w + 3;

            queue.add(x);
            if(idx == A) return ans;
            else ans[idx++] = x;
            queue.add(y);
            if(idx == A) return ans;
            else ans[idx++] = y;
            queue.add(z);
            if(idx == A) return ans;
            else ans[idx++] = z;
        }
        return new int[] {-1};
    }

    public static void main(String[] args) {
        int[] ans = new IntegersWithOnly1or2or3().solve(9);
        for(int n : ans) System.out.print(n + " ");
    }

}
