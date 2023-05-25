package advanced.dynamicProgramming;

import java.util.Arrays;

public class DistinctWaysToClimbStairs {

    public int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return util(n, dp);
    }

    public int util(int n, int[] dp) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        int takeOne = util(n-1, dp);
        int takeTwo = util(n-2, dp);

        return dp[n] = takeOne + takeTwo;
    }

    public int bottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int spaceOptimisedBottomUp(int n) {
        int prev = 1;
        int prev2 = 1;

        for(int i=2; i<=n; i++) {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new DistinctWaysToClimbStairs().spaceOptimisedBottomUp(88));
    }

}
