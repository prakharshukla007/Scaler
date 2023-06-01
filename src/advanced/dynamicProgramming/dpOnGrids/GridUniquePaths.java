package advanced.dynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class GridUniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return util(m-1, n-1, dp);
    }

    public static int util(int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = util(i-1, j, dp);
        int left = util(i, j-1, dp);

        return dp[i][j] = up + left;
    }

    public static int uniquePathsBottomUp(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) dp[0][0] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0)
                        up = dp[i-1][j];
                    if(j > 0)
                        left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static int uniquePathsBottomUpSpaceOptimised(int m, int n) {
        int[] prev = new int[m];

        for(int i=0; i<m; i++) {
            int[] cur = new int[n];
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) prev[0] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = cur[j-1];
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }

        return prev[n-1];
    }

}
