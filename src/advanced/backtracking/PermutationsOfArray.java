package advanced.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsOfArray {

    Set<ArrayList<Integer>> hs = new HashSet<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
//        if(A.size() <= 1) return 0;
        ArrayList<ArrayList<Integer>> permutation = new ArrayList<>();
        permuteUtil(A, permutation, 0);

        int count = 0;
        for(ArrayList<Integer> ls : permutation) {
            if(checkIfSquareful(ls)) count++;
        }

//        return count;
        return permutation;
    }

    public void permuteUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> permutations, int idx) {
        if(idx == A.size()) {
            if(!hs.contains(A)) {
                hs.add(A);
                permutations.add(new ArrayList<>(A));
            }
            return;
        }

        for(int i=idx; i<A.size(); i++) {
            swap(A, i, idx);
            permuteUtil(A, permutations, idx+1);
            swap(A, i, idx);
        }
    }

    public boolean checkIfSquareful(ArrayList<Integer> ls) {
        for(int i=0; i<ls.size()-1; i++) {
            int n1 = ls.get(i);
            int n2 = ls.get(i+1);
            if(!(Math.sqrt(n1 + n2) - (int)Math.sqrt(n1+n2) == 0)) return false;
        }
        return true;
    }

    public void swap(ArrayList<Integer> ls, int idx1, int idx2) {
        int temp = ls.get(idx1);
        ls.set(idx1, ls.get(idx2));
        ls.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(1));
        System.out.println(new PermutationsOfArray().permute(ls));
        System.out.println(Math.sqrt(5) - (int)Math.sqrt(5));
    }

}
