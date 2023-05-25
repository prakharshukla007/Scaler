package advanced.dynamicProgramming.knapsack;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return util(n-1, m-1, A, B, dp);
    }

    public int util(int idx1, int idx2, String source, String target, int[][] dp) {
        if(idx2 < 0) return 1;
        if(idx1 < 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(source.charAt(idx1) == target.charAt(idx2)) {
            int leave = util(idx1-1, idx2-1, source, target, dp);
            int stay = util(idx1-1, idx2, source, target, dp);
            return dp[idx1][idx2] = leave + stay;
        }
        else return dp[idx1][idx2] = util(idx1-1, idx2, source, target, dp);
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));
    }

}
