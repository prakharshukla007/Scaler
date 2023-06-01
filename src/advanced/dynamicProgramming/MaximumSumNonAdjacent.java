package advanced.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumNonAdjacent {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp, -1);
        return util(nums, n-1, dp);
    }

    public static int util(ArrayList<Integer> ar, int idx, int[] dp) {
        if(idx == 0) return ar.get(0);
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int notTake = util(ar, idx-1, dp);
        int take = ar.get(idx) + util(ar, idx-2, dp);

        return dp[idx] = Math.max(notTake, take);
    }

    public static int maximumNonAdjacentSumBottomUp(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n == 1) return nums.get(0);
        int[] dp = new int[n];
        dp[0] = nums.get(0);

        for(int i=1; i<n; i++) {
            int notTake = dp[i-1];
            int take = nums.get(i);
            if(i > 1) take += dp[i-2];
            dp[i] = Math.max(notTake, take);
        }

        return dp[n-1];
    }

    public static int maximumNonAdjacentSumBottomUpSpaceOptimised(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n == 1) return nums.get(0);
        int prev = nums.get(0);
        int prev2 = 0;

        for(int i=1; i<n; i++) {
            int notTake = prev;
            int take = nums.get(i);
            if(i > 1) take += prev2;
            int cur = Math.max(notTake, take);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSumNonAdjacent.maximumNonAdjacentSumBottomUp(new ArrayList<>(List.of(10))));
    }

}
