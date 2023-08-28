package tct_1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaxKDistinctChars {

    public int solve(String A, int B) {
        Map<Character, Integer> hm = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        int maxLen = Integer.MIN_VALUE;
        int curLen = 0;

        while(p2 < A.length()) {
            char c = A.charAt(p2);

            if(!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
            curLen++;

            if(hm.size() <= B) {
                maxLen = Math.max(maxLen, curLen);
            } else {
                char c2 = A.charAt(p1);
                hm.put(c2, hm.get(c2) - 1);
                if(hm.get(c2) == 0) hm.remove(c2);
                curLen--;
                p1++;
            }

            p2++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithMaxKDistinctChars().solve("acbaab", 2));
    }

}
