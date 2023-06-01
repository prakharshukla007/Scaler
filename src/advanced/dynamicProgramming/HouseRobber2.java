package advanced.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HouseRobber2 {

    public static long houseRobber(int[] houses) {
        int n = houses.length;
        if(n == 1) return houses[0];
        ArrayList<Integer> excludeLast = new ArrayList<>();
        ArrayList<Integer> excludeFirst = new ArrayList<>();
        for(int i=0; i<n-1; i++) excludeLast.add(houses[i]);
        for(int i=1; i<n; i++) excludeFirst.add(houses[i]);

        return Math.max(maximumNonAdjacentSumBottomUpSpaceOptimised(excludeFirst),
                maximumNonAdjacentSumBottomUpSpaceOptimised(excludeLast));
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

}
