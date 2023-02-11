package subsequencesAndSubsets;

import java.util.ArrayList;
import java.util.Arrays;

public class AllSubsets {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = A.size();

        for(int i=0; i<Math.pow(2, n); i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0; j<n; j++) {
                if(checkBit(i, j)) {
                    if(arr.isEmpty())
                        arr.add(A.get(j));
                    else {
                        if(arr.get(arr.size()-1) < A.get(j))
                            arr.add(A.get(j));
                        else {
                            arr.clear();
                            break;
                        }
                    }
                }
            }
            if(!arr.isEmpty())
                ans.add(arr);
        }

        ans.add(new ArrayList<>());
        return ans;
    }

    public static boolean checkBit(int i, int j) {
        return (i & (1 << j)) > 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1, -18));
        System.out.println(subsets(ls));
    }

}
