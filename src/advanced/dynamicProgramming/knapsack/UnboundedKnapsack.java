package advanced.dynamicProgramming.knapsack;

import java.util.Arrays;

public class UnboundedKnapsack {

    public int solve(int A, int[] B, int[] C) {
        int n = B.length;
        int[][] dp = new int[n][A+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return util(B, C, A, n-1, dp);
    }

    public int util(int[] val, int[] wt, int W, int idx, int[][] dp) {
        if(idx == 0) {
            if(wt[0] <= W) return (W/wt[0]) * val[idx];
            else return 0;
        }

        if(dp[idx][W] != -1) return dp[idx][W];

        int notTake = util(val, wt, W, idx - 1, dp);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= W) {
            take = val[idx] + util(val, wt, W-wt[idx], idx, dp);
        }

        return dp[idx][W] = Math.max(notTake, take);
    }

}
