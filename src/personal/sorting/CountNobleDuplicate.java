package personal.sorting;

import java.util.Arrays;

public class CountNobleDuplicate {

    // Same problem as CountNobleUnique but with duplicates
    public int countNoble(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int countLess = 0;
        int countNoble = 0;
        if(arr[0] == 0) countNoble++;
        for(int i=1; i<n; i++) {
            if(arr[i] != arr[i-1]) {
                countLess = i;
            }
            if(countLess == arr[i]) {
                countNoble++;
            }
        }

        return countNoble;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-10, -10, -5, 3, 3, 4, 4, 5};
        System.out.println(new CountNobleDuplicate().countNoble(arr));
    }

}
