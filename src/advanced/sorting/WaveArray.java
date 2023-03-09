package advanced.sorting;

import java.util.Arrays;

public class WaveArray {

    public static int[] wave(int[] A) {
        Arrays.sort(A);
        int n = A.length;

        for(int i=0; i<n; i+=2) {
            if(i+1 < n)
                swap(A, i, i+1);
        }

        return A;
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 4};
        int[] ans = wave(arr);
        for(int n : ans) System.out.print(n + " ");
    }

}
