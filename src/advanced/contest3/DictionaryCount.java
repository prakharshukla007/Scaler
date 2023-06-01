package advanced.contest3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryCount {

    public int solve(ArrayList<String> A, ArrayList<String> B) {
        Map<String, Integer> hm = new HashMap<>();
        for(String s : A) {
            if(hm.containsKey(s)) hm.put(s, -1);
            else {
                hm.put(s, 1);
            }
        }
        for(String s : B) {
            if(hm.containsKey(s)) {
                hm.put(s, hm.get(s) - 1);
                if(hm.get(s) < 0) hm.remove(s);
            }
        }

        int count = 0;
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            if(entry.getValue() == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DictionaryCount().solve(new ArrayList<>(List.of("is", "the", "a", "is")), new ArrayList<>(List.of("the", "an", "a", "is"))));
    }

}
