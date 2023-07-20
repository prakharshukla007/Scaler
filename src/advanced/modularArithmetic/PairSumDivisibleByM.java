package advanced.modularArithmetic;

import java.util.HashSet;
import java.util.Set;

public class PairSumDivisibleByM {

    public int solve(int[] A, int B) {
        int[] count = new int[B];
        for(int n : A) {
            count[n % B]++;
        }

        Set<Integer> visited = new HashSet<>();

        int ans = 0;
        if(count[0] != 0)
            ans += count[0] * (count[0] - 1)/2;
        for(int i=1; i<B; i++) {
            if(i == B-i) {
                ans += count[i] * (count[i] -1)/2;
            } else {
                if(!visited.contains(B - i)) {
                    ans += count[i] * count[B - i];
                    visited.add(i);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PairSumDivisibleByM().solve(new int[] {5, 17, 100, 11}, 28));
    }

}
