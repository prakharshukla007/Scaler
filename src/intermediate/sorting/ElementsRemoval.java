package intermediate.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ElementsRemoval {

    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int totalSum = 0;
        for(int n : A)
            totalSum += n;

        int ans = 0;
        for(int i=0; i<A.size(); i++) {
            if(i == 0)
                ans += totalSum;
            else {
                ans += totalSum - A.get(i-1);
                totalSum -= A.get(i-1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(8, 0, 10));
        System.out.println(solve(ls));
    }

}
