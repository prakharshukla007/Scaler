package advanced.dynamicProgramming.knapsack;

import java.util.Arrays;

public class Zero_One_Knapsack {

    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n][C + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return util(A, B, n - 1, C, dp);
    }

    public int util(int[] val, int[] wt, int idx, int W, int[][] dp) {
        if (idx == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        if (dp[idx][W] != -1) return dp[idx][W];

        int notTake = util(val, wt, idx - 1, W, dp);
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W)
            take = val[idx] + util(val, wt, idx - 1, W - wt[idx], dp);

        return dp[idx][W] = Math.max(notTake, take);
    }

    public int solveBottomUp(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                if (B[i-1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], A[i-1] + dp[i - 1][j - B[i-1]]);
            }
        }

        return dp[n][C];
    }

    public static void main(String[] args) {
        int[] A = new int[]{359, 963, 465, 706, 146, 282, 828, 962, 492};
        int[] B = new int[]{96, 43, 28, 37, 92, 5, 3, 54, 93};
        System.out.println(new Zero_One_Knapsack().solveBottomUp(A, B, 383));
    }

}
