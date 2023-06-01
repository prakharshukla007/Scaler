package advanced.dynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    public static int maxMoneyLooted(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return util(houses, n-1, dp);
    }

    public static int util(int[] houses, int idx, int[] dp) {
        if(idx == 0) return houses[0];
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int notLoot = util(houses, idx-1, dp);
        int loot = houses[idx] + util(houses, idx-2, dp);

        return dp[idx] = Math.max(notLoot, loot);
    }

    public static void main(String[] args) {
        System.out.println(HouseRobber.maxMoneyLooted(new int[]{10, 2, 3, 11}));
    }

}
