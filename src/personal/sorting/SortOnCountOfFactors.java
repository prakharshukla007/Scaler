package personal.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortOnCountOfFactors {

    public class FactorComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int fac1 = countFactors(o1);
            int fac2 = countFactors(o2);

            if(fac1 < fac2) return -1;
            if(fac1 > fac2) return 1;
            else {
                if(o1 < o2) return -1;
                if(o1 > o2) return 1;
                else return 0;
            }
        }
    }

    public void sort(Integer[] arr) {
        Arrays.sort(arr, new FactorComparator());
    }

    public int countFactors(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(n % i == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SortOnCountOfFactors().countFactors(10));
        Integer[] arr = new Integer[] {9, 3, 10, 6, 4};
        new SortOnCountOfFactors().sort(arr);
        for(int n : arr) System.out.print(n + " ");
    }

}
