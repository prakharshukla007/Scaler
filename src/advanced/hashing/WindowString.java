package advanced.hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public String minWindow(String A, String B) {
        int nA = A.length();
        HashMap<Character, Integer> hmB = new HashMap<>();
        for(char c : B.toCharArray()) {
            hmB.put(c, hmB.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> hmA = new HashMap<>();
        hmA.put(A.charAt(0), 1);
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        int l=0, r=0;
        while(l < nA) {
            if(isHmAGreater(hmB, hmA)) {
                if(r-l+1 < minLength) {
                    minLength = r-l+1;
                    ans = A.substring(l, r+1);
                }
                hmA.put(A.charAt(l), hmA.get(A.charAt(l)) - 1);
                l++;
            } else {
                r++;
                if(r == nA) break;
                hmA.put(A.charAt(r), hmA.getOrDefault(A.charAt(r), 0) + 1);
            }
        }

        return ans;
    }

    public boolean isHmAGreater(HashMap<Character, Integer> hm1, HashMap<Character, Integer> hm2) {
        for(Map.Entry<Character, Integer> entry : hm1.entrySet()) {
            if(entry.getValue() > hm2.getOrDefault(entry.getKey(), 0)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        System.out.println(new WindowString().minWindow(A, B));
    }

}
