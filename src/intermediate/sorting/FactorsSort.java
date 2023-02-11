package intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FactorsSort {

    public static class FactorsComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if(noOfFactors(o1) > noOfFactors(o2)) return 1;
            else if(noOfFactors(o1) < noOfFactors(o2)) return -1;
            else {
                if(o1 > o2) return 1;
                else if(o1 < o2) return -1;
                else return 0;
            }
        }

        public int noOfFactors(Integer n) {
            int count = 0;
            for(int i=1; i<=Math.sqrt(n); i++) {
                if(n % i == 0) count++;
            }
            return count;
        }

    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new FactorsComparator());
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(36, 13, 13, 26, 37, 28, 27, 43, 7));
        System.out.println(solve(ls));
    }

}
