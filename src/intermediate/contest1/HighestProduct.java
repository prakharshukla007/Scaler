package intermediate.contest1;

import java.util.Arrays;

public class HighestProduct {

    public static int maxp3(int[] A) {
        int n = A.length;
        if(n < 3)
            return -1;
        Arrays.sort(A);
        int prod1 = A[0] * A[1] * A[2];
        int prod2 = A[n-1] * A[n-2] * A[n-3];
        return Math.max(prod1, prod2);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, -1, 3, 100, -70, -50};
        System.out.println(maxp3(arr));
    }

}
