package advanced.arrays;

public class MaxDroneJump {

    /*
        Given n buildings, with height of each building. There is a small drone on top of each building which can only move up and right.
        Find how high AT MAX a drone can jump from one location to another.
     */

    public static int[] calcHMax(int[] arr) {
        int n = arr.length;
        //int[] hMax = new int[n];

        int currMax = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--) {
            if(arr[i] > currMax) currMax = arr[i];
            arr[i] = currMax;
        }

        return arr;
    }

    public static int findMaxJump(int[] arr) {
        int n = arr.length;
        int maxR = arr[n-1]; // Maximum right jump
        int ans = 0;
        for(int i=n-2; i>=0; i--) {
            maxR = Math.max(maxR, arr[i]);
            ans = Math.max(ans, maxR - arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 3, 2, 4, 1, 3, 5, 3, 4};
        int[] arr2 = new int[] {6, 5, 5, 5, 5, 5, 5, 4, 4};

        // int[] hMax = calcHMax(arr);
        // for(int n : hMax) System.out.print(n + " ");
        System.out.println(findMaxJump(arr));
    }

}
