package advanced.binarySearch;

public class SquareRoot {

    // This calculates floor of the square root
    public int findSquareRoot(int n) {
        int lo = 1;
        int hi = n;

        int ans = -1;
        while(lo <= hi) {
            int mid = (lo + hi)/2;

            if(mid * mid == n) return mid;

            if(mid * mid > n) hi = mid - 1;
            else {
                ans = mid;
                lo = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().findSquareRoot(50));
    }

}
