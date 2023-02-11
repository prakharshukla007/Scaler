package intermediate.hashMapAndSet;

import java.util.HashMap;

public class DistinctNumbersInWindow {

    public static int[] dNums(int[] A, int B) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<B; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        int ans[] = new int[n-B+1];
        ans[0] = hm.size();

        int p1 = 1;
        int p2 = B;
        int idx = 1;
        while(p2 < n) {
            hm.put(A[p1-1], hm.get(A[p1-1]) - 1);
            if(hm.get(A[p1-1]) == 0) hm.remove(A[p1-1]);
            hm.put(A[p2], hm.getOrDefault(A[p2], 0) + 1);
            ans[idx++] = hm.size();
            p1++;
            p2++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 1, 3, 4, 3};
        int[] ans = dNums(A, 3);
        for(int n : ans) System.out.print(n + " ");
    }

}
