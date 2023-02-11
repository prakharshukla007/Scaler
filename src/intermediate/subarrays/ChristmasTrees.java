package subarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ChristmasTrees {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<n-1; i++) {
            int minCostLeft = Integer.MAX_VALUE;
            for(int j=i-1; j>=0; j--) {
                if(A.get(j) < A.get(i)) {
                    if(B.get(j) < minCostLeft) minCostLeft = B.get(j);
                }
            }

            int minCostRight = Integer.MAX_VALUE;
            for(int j=i+1; j<n; j++) {
                if(A.get(j) > A.get(i)) {
                    if(B.get(j) < minCostRight) minCostRight = B.get(j);
                }
            }

            if(minCostLeft != Integer.MAX_VALUE && minCostRight != Integer.MAX_VALUE) ans = Math.min(ans, B.get(i) + minCostRight + minCostLeft);
        }

        if(ans != Integer.MAX_VALUE)
            return ans;
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 6, 4, 2, 6, 9));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 5, 7, 3, 2, 7));
        System.out.println(solve(A, B));
    }

}
