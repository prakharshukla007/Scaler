package intermediate.subarrays;

import java.util.ArrayList;

public class AllSubArrays {

    public static int printAllSubarrays(int[] A, int B) {
        int n = A.length;

        //prefixSum
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for(int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            for(int grpSize=1; grpSize<=n; grpSize++) {
                if(i+grpSize-1 < n) {
                    int sum = i == 0 ? prefixSum[grpSize - 1] : prefixSum[i + grpSize - 1] - prefixSum[i - 1];
                    if (grpSize % 2 == 0 && sum < B)
                        count++;
                    else if (grpSize % 2 != 0 && sum > B)
                        count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        System.out.println(printAllSubarrays(arr, 65));
    }

}
