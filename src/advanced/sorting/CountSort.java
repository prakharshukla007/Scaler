package advanced.sorting;

public class CountSort {

    public int[] solve(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            max = Math.max(max, A[i]);
        }

        int[] freq = new int[max+1];
        for(int n1 : A) freq[n1]++;

        int idx = 0;
        for(int i=1; i<=max; i++) {
            if(freq[i] != 0) {
                for(int j=0; j<freq[i]; j++) A[idx++] = i;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        CountSort obj = new CountSort();
        int[] arr = new int[] {6, 3, 3, 6, 7, 8, 7, 3, 7};
        int[] ans = obj.solve(arr);
        for(int n : ans) System.out.print(n + " ");
    }

}
