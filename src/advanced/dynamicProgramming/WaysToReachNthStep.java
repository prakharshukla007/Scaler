package advanced.dynamicProgramming;

import java.util.Arrays;

public class WaysToReachNthStep {

    public static int countDistinctWayToClimbStair(int nStairs) {
        int[] dp = new int[nStairs + 1];
        Arrays.fill(dp, -1);
        return util(nStairs, dp);
    }

    public static int util(int nStairs, int[] dp) {
        // Write your code here.
        if(nStairs == 0) return 1;
        if(nStairs == 1) return 1;

        if(dp[nStairs] != -1) return dp[nStairs];

        return dp[nStairs] = countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2);
    }

    public static void main(String[] args) {
        System.out.println(WaysToReachNthStep.countDistinctWayToClimbStair(3));
    }

}
