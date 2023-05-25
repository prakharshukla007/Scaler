package advanced.dynamicProgramming;

public class MaxSumWithoutAdjacentElements {

    public int adjacent(int[][] A) {
        int m = A[0].length;
        Integer[] dp = new Integer[m];
        dp[0] = (Math.max(A[0][0], A[1][0]));

        if (m == 1) return dp[0];
        dp[1] = (Math.max(dp[0], Math.max(A[0][1], A[1][1])));
        if (m == 2) return dp[1];

        return adj(A, dp, m - 1);
    }

    public int adj(int[][] A, Integer[] dp, int i) {
        if (i == 0) return dp[0];
        if (i == 1) return dp[1];

        if (dp[i] != null) return dp[i];

        int a = Math.max(A[0][i], A[1][i]) + adj(A, dp, i - 2);
        int b = adj(A, dp, i - 1);

        dp[i] = Math.max(a, b);

        return dp[i];
    }

}
