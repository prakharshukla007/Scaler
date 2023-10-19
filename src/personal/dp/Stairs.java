package personal.dp;

import java.util.Arrays;

public class Stairs {
    int mod = 1000000007;
    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);
        return util(A, dp);
    }
    public int util(int A, int[] dp) {
        if(A == 0) return 1;
        if(A == 1) return 1;

        if(dp[A] != -1) return dp[A];
        else return dp[A] = (climbStairs(A - 1) + climbStairs(A - 2)) % mod;
    }
    public int climbStairsIter(int A) {
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=A; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }

        return dp[A];
    }
    public static void main(String[] args) {
        System.out.println(new Stairs().climbStairsIter(55007));
    }
}
