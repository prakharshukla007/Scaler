package advanced.dynamicProgramming.knapsack;

import java.util.Arrays;

public class CoinSumInfinite {

    int mod = 1000007;

    public int coinchange2(int[] A, int B) {
        int n = A.length;
        long[][] dp = new long[n][B+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return (int) (util(A, B, n-1, dp) % mod);
    }

    public long util(int[] coins, int targetSum, int idx, long[][] dp) {
        if(idx == 0) {
            return targetSum % coins[0] == 0 ? 1 : 0;
        }

        if(dp[idx][targetSum] != -1) return dp[idx][targetSum];

        long notTake = util(coins, targetSum, idx-1, dp) % mod;
        long take = 0;
        if(targetSum >= coins[idx]) take = util(coins, targetSum-coins[idx], idx, dp) % mod;

        return dp[idx][targetSum] = ((notTake)%mod + (take)%mod);
    }

}
