package personal.binarySearch;

public class FindUniqueAmongPairsOfNumbers {

    public int solve(int[] arr) {
        int n = arr.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if ((mid == 0 || arr[mid] != arr[mid - 1]) &&
                    (mid == n - 1 || arr[mid] != arr[mid + 1]))
                return arr[mid];

            if(mid != 0 && arr[mid] == arr[mid-1]) {
                if(mid % 2 == 0) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if(mid % 2 == 0) lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 5, 5, 8, 10, 10, 13, 13, 18, 18};
        System.out.println(new FindUniqueAmongPairsOfNumbers().solve(arr));
    }

}
