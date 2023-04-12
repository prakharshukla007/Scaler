package advanced.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PairsWithGivenDifference {

    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : A)
            hm.put(num, hm.getOrDefault(num, 0) + 1);

        HashSet<Integer> hs = new HashSet<>();
        for(int n1 : A) hs.add(n1);

        ArrayList<Integer> ls = new ArrayList<>(hs);

        int count = 0;
        for(int n2 : ls) {
            if(B == 0 && hm.get(n2) > 1) count++;
            else {
                if(hm.containsKey(n2 + B)) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2};
        System.out.println(new PairsWithGivenDifference().solve(arr, 0));
    }

}
