package advanced.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class FlipAndFindNearest {

    public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
        TreeSet<Integer> hs = new TreeSet<>();
        int n = A.length();

        for(int i=0; i<n; i++) {
            if(A.charAt(i) == '1') hs.add(i+1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> ls : B) {
            int queryType = ls.get(0);
            int idx = ls.get(1);

            if(queryType == 1) {
                if(hs.contains(idx)) hs.remove(idx);
                else hs.add(idx);
            } else {
                int nearestLeftIdx = Integer.MIN_VALUE, nearestRightIdx = Integer.MAX_VALUE;
                if(hs.ceiling(idx) != null) {
                    nearestRightIdx = hs.ceiling(idx);
                }
                if(hs.floor(idx) != null) {
                    nearestLeftIdx = hs.floor(idx);
                }

                if(nearestLeftIdx == Integer.MIN_VALUE && nearestRightIdx == Integer.MAX_VALUE) ans.add(-1);
                if(nearestLeftIdx != Integer.MIN_VALUE && ((idx - nearestLeftIdx) <= (nearestRightIdx - idx))) ans.add(nearestLeftIdx);
                else ans.add(nearestRightIdx);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        ls.add(new ArrayList<>(List.of(1, 3)));
        ls.add(new ArrayList<>(List.of(1, 3)));
        ls.add(new ArrayList<>(List.of(2, 4)));
        ls.add(new ArrayList<>(List.of(2, 2)));
        ls.add(new ArrayList<>(List.of(1, 1)));
        ls.add(new ArrayList<>(List.of(2, 3)));
        ls.add(new ArrayList<>(List.of(1, 5)));
        ls.add(new ArrayList<>(List.of(1, 5)));

        System.out.println(new FlipAndFindNearest().solve("10010", ls));
    }

}
