package advanced.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    public static boolean nextPerm(ArrayList<Integer> A) {
        int n = A.size();

        int idxToSwap1 = -1;
        for(int i=n-2; i>=0; i--) {
            if(A.get(i) < A.get(i+1)) {
                idxToSwap1 = i;
                break;
            }
        }

        if(idxToSwap1 == -1) return false;

        int idxToSwap2 = -1;
        for(int i=n-1; i>=idxToSwap1; i--) {
            if(A.get(i) > A.get(idxToSwap1)) {
                idxToSwap2 = i;
                break;
            }
        }

        swap(A, idxToSwap1, idxToSwap2);

        idxToSwap1++;
        int steps = (n - idxToSwap1 + 1)/2;

        for(int i=0; i<steps; i++) {
            swap(A, idxToSwap1 + i, n - i - 1);
        }

        return true;
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        boolean status = nextPerm(A);
        if(!status) Collections.sort(A);
        return A;
    }

    public static void swap(ArrayList<Integer> ls, int p1, int p2) {
        int temp = ls.get(p1);
        ls.set(p1, ls.get(p2));
        ls.set(p2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(nextPermutation(ls));

        Double d1 = Double.valueOf(0);
        Double d2 = Double.valueOf(0);
        System.out.println(d1 == d2);
    }

}
