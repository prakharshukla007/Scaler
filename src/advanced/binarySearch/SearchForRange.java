package advanced.binarySearch;

public class SearchForRange {

    public int[] searchRange(final int[] A, int B) {
        int n = A.length;
        int l = 0;
        int r = n-1;

        int start = -1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(A[mid] == B && (mid == 0 || A[mid-1] != A[mid])) {
                start = mid;
                r = mid - 1;
            }
            if(A[mid] < B) l = mid + 1;
            else r = mid - 1;
        }

        l = 0;
        r = n-1;
        int end = -1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(A[mid] == B && (mid == n-1 || A[mid+1] != A[mid])) {
                end = mid;
                l = mid + 1;
            }
            if(A[mid] > B) r = mid - 1;
            else l = mid + 1;
        }

        return new int[] {start, end};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 4};
        SearchForRange obj = new SearchForRange();
        int[] ans = obj.searchRange(arr, 4);
        for(int n : ans) System.out.print(n + " ");
    }

}
