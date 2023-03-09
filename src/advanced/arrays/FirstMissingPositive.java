package advanced.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingPositive {

    public static int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        int i = 0;
        while(i < n) {
            if(A.get(i) < 1 || A.get(i) > i || A.get(i) == i+1)
                i++;
            else {
                int idx = A.get(i) - 1;
                if(A.get(idx) != A.get(i))
                    swap(A, i, idx);
                else
                    i++;
            }
        }

        for(i=0; i<n; i++) {
            if(A.get(i) != i+1) return i+1;
        }

        return n+1;
    }

    public static void swap(ArrayList<Integer> ls, int i, int j) {
        int temp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(0, 3, 1, 2));
        System.out.println(firstMissingPositive(ls));
    }

}
