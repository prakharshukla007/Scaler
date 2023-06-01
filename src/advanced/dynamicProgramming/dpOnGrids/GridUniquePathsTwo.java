package advanced.dynamicProgramming.dpOnGrids;

import java.util.ArrayList;
import java.util.Arrays;

public class GridUniquePathsTwo {

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        return util2(n-1, m-1, mat);
    }

    static int util2(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(mat.get(i).get(j) == -1) return 0;

        int up = util2(i-1, j, mat);
        int left = util2(i, j-1, mat);

        return up + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return mazeObstaclesBottomUp(obstacleGrid.length, obstacleGrid[0].length, obstacleGrid);
    }

    static int mazeObstaclesBottomUp(int n, int m, int[][] mat) {
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 && j == 0) dp[0][0] = 1;
                else if(mat[i][j] == -1) dp[i][j] = 0;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[n-1][m-1];
    }

}