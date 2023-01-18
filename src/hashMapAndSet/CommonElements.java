package hashMapAndSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Long, Long> hm1 = new HashMap<>();
        for(int n : A) {
            hm1.put((long)n, hm1.getOrDefault((long)n, 0L) + 1);
        }

        HashMap<Long, Long> hm2 = new HashMap<>();
        for(int n : B) {
            hm2.put((long)n, hm2.getOrDefault((long)n, 0L) + 1);
        }

        if(hm1.size() <= hm2.size()) {
            for(Long n : hm1.keySet()) {
                if(hm2.containsKey(n)) {
                    long count = Math.min(hm1.get(n), hm2.get(n));
                    while(count > 0) {
                        ans.add(n.intValue());
                        count--;
                    }
                }
            }
        }
        else if(hm1.size() > hm2.size()) {
            for(Long n : hm2.keySet()) {
                if(hm1.containsKey(n)) {
                    long count = Math.min(hm1.get(n), hm2.get(n));
                    while(count > 0) {
                        ans.add(n.intValue());
                        count--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 3, 1, 2));
        System.out.println(solve(arr1, arr2));
    }

}
