package intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TensDigitSorting {

    public static class TensDigitComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int firstTensDigit = 0;
            int o1Temp = o1;
            for(int i=0; i<2; i++) {
                firstTensDigit = o1 % 10;
                o1 = o1/10;
            }
            int secondTensDigit = 0;
            int o2Temp = o2;
            for(int i=0; i<2; i++) {
                secondTensDigit = o2 % 10;
                o2 = o2/10;
            }

            if(firstTensDigit < secondTensDigit) return -1;
            else if(firstTensDigit > secondTensDigit) return 1;
            else {
                if(o1Temp > o2Temp) return -1;
                else if(o1Temp < o2Temp) return 1;
                else return 0;
            }
        }

    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new TensDigitComparator());
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(15, 11, 7, 19));
        ls = solve(ls);
        System.out.println(ls);
    }

}
