package advanced.sorting;

public class MaximumUnsortedSubarray {

    public int[] subUnsort(int[] A) {
        int n = A.length;

        int p1 = 1;
        int p2 = n-2;

        while(p1 < n) {
            if(A[p1] < A[p1-1]) break;
            p1++;
        }

        while(p2 >= 0) {
            if(A[p2] > A[p2+1]) break;
            p2--;
        }
        p2++;

        while(p2+1 < n && A[p2+1] == A[p2]) p2++;

        if(p1 == n) return new int[] {-1};
        return new int[] {p1-1, p2+1};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 4, 5};
        MaximumUnsortedSubarray obj = new MaximumUnsortedSubarray();
        int[] ans = obj.subUnsort(arr);
        for(int n : ans) System.out.print(n + " ");
    }

}
