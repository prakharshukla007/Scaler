package advanced.dynamicProgramming.knapsack;

import java.util.Arrays;

public class CuttingRod {

    public int solve(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return util(A, n, n, dp);
    }

    public int util(int[] A, int idx, int size, int[][] dp) {
        if(idx == 1) {
            if(size >= 1) return size * A[0];
            else return 0;
        }

        if(dp[idx-1][size] != -1) return dp[idx-1][size];

        int notTake = util(A, idx-1, size, dp);
        int take = Integer.MIN_VALUE;
        if(idx <= size) {
            take = A[idx-1] + util(A, idx, size-idx, dp); // Unbounded knapsack hence index not decremented
        }

        return dp[idx-1][size] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] ar = new int[] {3, 4, 1, 6, 2};
        System.out.println(new CuttingRod().solve(ar));
    }

}
