package hashMapAndSet;

import java.util.HashMap;

public class LongestSubarrayZeroSum {

    public static int solve(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];

        for(int i=1; i<n; i++) prefixSum[i] = prefixSum[i-1] + A[i];

        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(prefixSum[i] == 0) {
                maxLength = Math.max(maxLength, i+1);
            }
            else if(hm.containsKey(prefixSum[i])) {
                maxLength = Math.max(maxLength, i - hm.get(prefixSum[i]));
            }
            else {
                hm.put(prefixSum[i], i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, -20, -11, -8, -4, 2, -12, 14, 1};
        System.out.println(solve(arr));
    }

}
