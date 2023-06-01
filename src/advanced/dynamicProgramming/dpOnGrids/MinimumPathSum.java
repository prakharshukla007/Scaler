package advanced.dynamicProgramming.dpOnGrids;

import java.util.Arrays;

public class MinimumPathSum {

    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return util(n-1, m-1, grid, dp);
    }

    public static int util(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up = util(i-1, j, grid, dp);
        int down = util(i, j-1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, down);
    }

    public static int minSumPathBottomUp(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 && j == 0) dp[0][0] = grid[0][0];
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[n-1][m-1];
    }

}
