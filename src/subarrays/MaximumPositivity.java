package subarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPositivity {

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int n = A.size();

        //First window of non-negative numbers
        int idx = 0;
        for(idx=0; idx<n; idx++) {
            if(A.get(idx) >= 0) arr1.add(A.get(idx));
            else if(!arr1.isEmpty()) break;
        }

        for(int i=idx; i<n; i++) {
            if(A.get(i) >= 0) {
                arr2.add(A.get(i));
                if(arr2.size() > arr1.size()) {
                    arr1 = arr2;
                }
            }
            else if(!arr2.isEmpty()) arr2 = new ArrayList<>();
        }

        return arr1;

    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(8986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575));
        System.out.println(solve(ls));
    }

}
