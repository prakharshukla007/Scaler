package intermediate.sorting;

import java.util.*;

public class LargestNumber {

    public static class NumberComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            return (s2+s1).compareTo(s1+s2);
        }

    }

    public static String largestNumber(final List<Integer> A) {
        Collections.sort(A, new NumberComparator());
        String ans = "";
        for(Integer n : A) {
            if(ans.isEmpty() && n == 0) continue;
            ans += n;
        }
        if(ans.isEmpty()) return "0";
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        System.out.println(largestNumber(ls));
    }

}
