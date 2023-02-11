package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobelInteger {

    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int noOfNobels = -1;
        int countLess = 0;
        if(A.get(0) == 0) noOfNobels = 1;
        for(int i=1; i<A.size(); i++) {
            if(A.get(i) != A.get(i-1)) countLess = i;
            if(A.get(i) == countLess) noOfNobels = noOfNobels == -1 ? 1 : noOfNobels + 1;
        }
        return noOfNobels;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(5, 6, 2));
        System.out.println(solve(ls));
    }

}
