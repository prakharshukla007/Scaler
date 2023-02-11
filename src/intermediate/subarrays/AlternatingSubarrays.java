package intermediate.subarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternatingSubarrays {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        //Start from index B in Array
        for(int i=B; i<n-B; i++) {
            if(checkIf01(A, i, B))
                res.add(i);
        }
        return res;
    }

    public static boolean checkIf01(ArrayList<Integer> ls, int i, int B) {
        for(int j=i-B; j<i+B; j++) {
            if(ls.get(j) == ls.get(j+1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1));
        int B = 1;
        System.out.println(solve(ls, B));
    }

}
