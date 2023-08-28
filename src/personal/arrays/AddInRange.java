package personal.arrays;

public class AddInRange {

    public int[] solve(int[] arr, int[][] queries) {
        int n = arr.length;

        for(int[] ar : queries) {
            arr[ar[0]] += ar[2];
            if(ar[1] < n-1) arr[ar[1] + 1] -= ar[2];
        }

        for(int i=1; i<n; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] queries = new int[4][];
        queries[0] = new int[] {3, 6, 1};
        queries[1] = new int[] {2, 7, 3};
        queries[2] = new int[] {5, 8, -3};
        queries[3] = new int[] {1, 9, 2};

        int[] ans = new AddInRange().solve(arr, queries);
        for(int n : ans) System.out.print(n + " ");
    }

}
