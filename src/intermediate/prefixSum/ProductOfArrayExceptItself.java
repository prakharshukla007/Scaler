package intermediate.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOfArrayExceptItself {

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size();
        int[] prefixProducts = new int[n];
        prefixProducts[0] = A.get(0);
        for(int i=1; i<n; i++)
            prefixProducts[i] = prefixProducts[i-1] * A.get(i);

        int[] postfixProducts = new int[n];
        postfixProducts[n-1] = A.get(n-1);
        for(int i=n-2; i>=0; i--)
            postfixProducts[i] = postfixProducts[i+1] * A.get(i);

        for(int i=0; i<n; i++) {
            if(i == 0)
                res.add(postfixProducts[1]);
            else if(i == n-1)
                res.add(prefixProducts[i-1]);
            else
                res.add(prefixProducts[i-1] * postfixProducts[i+1]);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        System.out.println(solve(ls));
    }

}
