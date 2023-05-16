package advanced.backtracking;

import java.util.*;

public class SubsetsOfArray {

    Set<ArrayList<Integer>> hs = new HashSet<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        findSubsets(subsets, A, new ArrayList<>(), 0);

        Collections.sort(subsets, (a, b) -> {
            int n = Math.min(a.size(), b.size());
            for(int i=0; i<n; i++) {
                if(a.get(i) == b.get(i)) continue;
                else return a.get(i) - b.get(i);
            }
            return a.size() - b.size();
        });

        return subsets;
    }

    public void findSubsets(ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> nums, ArrayList<Integer> output, int idx) {
        if(idx == nums.size()) {
            Collections.sort(output);
            if(!hs.contains(output)) {
                hs.add(output);
                subsets.add(output);
            }
            return;
        }

        findSubsets(subsets, nums, new ArrayList<>(output), idx+1);
        output.add(nums.get(idx));
        findSubsets(subsets, nums, new ArrayList<>(output), idx+1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(1, 2, 3, 3));
        System.out.println(new SubsetsOfArray().subsets(ls));
    }

}
