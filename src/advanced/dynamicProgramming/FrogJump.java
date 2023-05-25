package advanced.dynamicProgramming;

import java.util.Arrays;

public class FrogJump {

    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return util(n-1, heights, 0, dp);
    }

    public static int util(int stair, int[] heights, int energy, int[] dp) {
        if(stair == 0) return energy;
        if(stair == 1) return energy + Math.abs(heights[0] - heights[1]);

        if(dp[stair] != -1) return dp[stair];

        int oneStair = util(stair-1, heights, energy + Math.abs(heights[stair] - heights[stair-1]), dp);
        int twoStairs = util(stair-2, heights, energy + Math.abs(heights[stair] - heights[stair-2]), dp);

        return dp[stair] = Math.min(oneStair, twoStairs);
    }

    public static void main(String[] args) {
        System.out.println(FrogJump.frogJump(4, new int[]{10, 20, 30, 10}));
    }

}
