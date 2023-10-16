package personal.sorting;

import java.util.Arrays;

public class CountNobleUnique {

    // Find count of noble integers in a given array. Noble int - count of elements smaller than A[i]
    public int nobleCount(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int count = 0;
        for(int i=0; i<n; i++) {
            if(i == arr[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, -5, 3, 5, -10, 4};
        System.out.println(new CountNobleUnique().nobleCount(arr));
    }

}
