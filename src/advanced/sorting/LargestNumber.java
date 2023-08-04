package advanced.sorting;

import java.util.*;

public class LargestNumber {

    public class CustomComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.parseInt(o2 + String.valueOf(o1)) - Integer.parseInt(o1 + String.valueOf(o2));
        }
    }

    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, new CustomComparator());
        String ans = "";
        for(int n : A) ans += n;
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>(List.of(3, 30, 34, 5, 9));
        System.out.println(new LargestNumber().largestNumber(ls));
    }

}
