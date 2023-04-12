package advanced.stringPatternMatching;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {

    public int solve(int A, String B) {
        if(A == 1) return 1;

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : B.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if(entry.getValue() % A != 0) return 0;
        }

        return 1;
    }



}
