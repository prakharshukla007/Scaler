package advanced.sorting;

public class CountInversions {

    public static int solve(int[] A) {
        return mergeSort(A, 0, A.length-1);
    }
    public static int mergeSort(int[] A, int start, int end) {
        if(start == end) return 0;
        int mid = (start + end)/2;
        mergeSort(A, start, mid);
        mergeSort(A, mid+1, end);
        return merge(A, start, mid, end);
    }
    public static int merge(int[] A, int start, int mid, int end) {
        int n = A.length;

        int[] leftSub = new int[mid-start+1];
        int[] rightSub = new int[end-mid];

        for(int i=start; i<=mid; i++) {
            leftSub[i] = A[i];
        }
        for(int i=mid+1; i<=end; i++) {
            rightSub[i] = A[i];
        }

        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        int count = 0;
        while(p1 < leftSub.length && p2 < rightSub.length) {
            if(leftSub[p1] <= rightSub[p2]) {
                A[idx++] = leftSub[p1++];
            }
            else {
                A[idx++] = rightSub[p2];
                count += n-p2++;
            }
        }

        while(p1 < leftSub.length)
            A[idx++] = leftSub[p1++];
        while(p2 < rightSub.length) {
            A[idx++] = rightSub[p2];
            count += n-p2++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {45, 10, 15, 25, 50};
        System.out.println(solve(arr));
    }

}
