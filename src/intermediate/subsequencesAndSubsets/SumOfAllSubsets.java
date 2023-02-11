package intermediate.subsequencesAndSubsets;

import java.util.ArrayList;

public class SumOfAllSubsets {

    public static ArrayList<Integer> sumsOfAllSubsets(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<Math.pow(2, n); i++) {
            int sum = 0;
            //For each i check bitwise index
            for(int j=0; j<n; j++) {
                if(checkBit(i, j)) sum += arr[j];
            }
            ans.add(sum);
        }

        return ans;
    }

    public static int sumOfAllSubsets(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++)
            sum += arr[i] * Math.pow(2, n-1);
        return sum;
    }

    public static boolean checkBit(int i, int j) {
        return (i & (1 << j)) > 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, -2, 1};
        System.out.println(sumsOfAllSubsets(arr));
        System.out.println(sumOfAllSubsets(arr));
    }

}
