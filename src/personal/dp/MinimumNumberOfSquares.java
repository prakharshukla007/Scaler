package personal.dp;

import java.util.Arrays;

public class MinimumNumberOfSquares {

    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);
        return util(A, dp);
    }

    public int countMinSquaresIter(int A) {
        int[] dp = new int[A+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=A; i++) {
            int min = Integer.MAX_VALUE;
            for(int k=1; k*k<=i; k++) {
                min = Math.min(min, dp[i - (k*k)]);
            }
            dp[i] = min + 1;
        }

        return dp[A];
    }

    public int util(int A, int[] dp) {
        if(A == 0 || A == 1) return A;

        if(dp[A] != -1) return dp[A];

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=A; i++) {
            min = Math.min(min, util(A - (i*i), dp));
        }

        return dp[A] = min + 1;
    }

}
