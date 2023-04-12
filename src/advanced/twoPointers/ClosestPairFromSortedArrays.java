package advanced.twoPointers;

public class ClosestPairFromSortedArrays {

    public int[] solve(int[] A, int[] B, int C) {
        int n1 = A.length;
        int n2 = B.length;
        int p1 = 0;
        int p2 = 0;

        int[] newArr = new int[n1 + n2];

        int idx = 0;
        while(p1 < n1 && p2 < n2) {
            if(A[p1] < B[p2]) newArr[idx++] = A[p1++];
            else if(A[p1] > B[p2]) newArr[idx++] = B[p2++];
            else {
                newArr[idx++] = A[p1++];
                newArr[idx++] = B[p2++];
            }
        }

        while(p1 < n1) newArr[idx++] = A[p1++];
        while(p2 < n2) newArr[idx++] = B[p2++];

        int n = n1 + n2;
        int i = 0;
        int j = n-1;
        int minDiff = Integer.MAX_VALUE;
        int ans[] = new int[] {-1, -1};
        while(i < j) {
            int sum = newArr[i] + newArr[j];
            if(Math.abs(C - sum) < minDiff) {
                minDiff = Math.abs(C - sum);
                ans = new int[] {newArr[i], newArr[j]};
            }
            if(sum == C) return new int[] {newArr[i], newArr[j]};
            if(sum < C) i++;
            else j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {5, 10, 20};
        int[] arr2 = new int[] {1, 2, 30};
        int[] ans = new ClosestPairFromSortedArrays().solve(arr1, arr2, 9);
        for(int n : ans) System.out.print(n + " ");
    }

}
