package advanced.twoPointers;

import java.util.Arrays;

public class ThreeSum {

    public int threeSumClosest(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);

        if(n == 3) return A[0] + A[1] + A[2];

        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int p1=0; p1<=n-3; p1++) {
            int p2 = p1+1;
            int p3 = n-1;
            while(p2 < p3) {
                int sum = A[p1] + A[p2] + A[p3];
                if(Math.abs(B - sum) < minDiff) {
                    minDiff = Math.abs(B - sum);
                    ans = sum;
                }
                if(sum == B) return sum;
                if(sum <= B) p2++;
                else p3--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, -9, -7, -8, 2, -8, 2, 3, -8};
        System.out.println(new ThreeSum().threeSumClosest(arr, -1));
    }

}
