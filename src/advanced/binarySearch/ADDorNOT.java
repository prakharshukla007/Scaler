package advanced.binarySearch;

import java.util.Arrays;

public class ADDorNOT {

    public int[] solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        for(int i=0; i<n; i++) {
            int count = 0;
            int operations = B;
            for(int j=i; j>=0; j--) {
                int diff = A[i] - A[j];
                if(diff <= operations) {
                    count++;
                    operations -= diff;
                } else break;
            }
            if(count > ans[0]) {
                ans[0] = count;
                ans[1] = A[i];
            }
        }

        return ans;
    }

    public int[] solveBS(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for(int i=1; i<n; i++) prefixSum[i] = prefixSum[i-1] + A[i];

        for(int i=0; i<n; i++) {
            int lo = 1;
            int hi = i+1;
            while(lo <= hi) {
                int mid = (lo + hi)/2;

                int sumOfMidNumbersBeforeI = i - mid < 0 ? prefixSum[i] : prefixSum[i] - prefixSum[i-mid];
                if(mid * A[i] - sumOfMidNumbersBeforeI <= B) {
                    if(ans[0] < mid) {
                        ans[0] = mid;
                        ans[1] = A[i];
                    }
                    lo = mid + 1;
                }
                else hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 2, 2, 1}; // 1 1 2 2 3
        for(int n : new ADDorNOT().solveBS(arr, 3)) System.out.print(n + " ");
    }

}
