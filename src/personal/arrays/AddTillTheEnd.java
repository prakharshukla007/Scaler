package personal.arrays;

public class AddTillTheEnd {

    public int[] solve(int[] arr, int[][] queries) {
        int n = arr.length;

        for(int[] ar : queries) {
            arr[ar[0]] += ar[1];
        }

        for(int i=1; i<n; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 0, 0, 0, 0, 0};
        int[][] queries = new int[4][2];
        queries[0] = new int[] {2, 4};
        queries[1] = new int[] {3, -1};
        queries[2] = new int[] {0, 2};
        queries[3] = new int[] {4, 1};

        int[] ans = new AddTillTheEnd().solve(arr, queries);
        for(int n : ans) System.out.print(n + " ");
    }

}
