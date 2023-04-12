package advanced.hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(final int[] A) {
        int n = A.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int num : A) hs.add(num);

        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(i!=0 &&  hs.contains(A[i]-1)) continue;
            else {
                int len = 1;
                while(hs.contains(A[i] + len)) len++;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] arr = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(obj.longestConsecutive(arr));
    }

}
