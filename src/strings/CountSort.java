package strings;

import java.util.Arrays;

public class CountSort {

    public static int[] solve(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        for(int n1 : A)
            max = Math.max(max, n1);

        int[] countArr = new int[max + 1];
        for(int n1 : A) countArr[n1]++;

        int[] ans = new int[n+1];
        int k = 0;
        for(int i=0; i<countArr.length; i++) {
            if(countArr[i] != 0) {
                for(int j=0; j<countArr[i]; j++) ans[k++] = i;
            }
        }

        for(int i=0; i<n; i++)
            A[i] = ans[i];

        return A;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 3, 3, 6, 7, 8, 7, 3, 7 };
        System.out.println(Arrays.toString(solve(arr)));
    }

}
