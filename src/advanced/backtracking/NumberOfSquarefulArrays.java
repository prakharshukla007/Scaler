package advanced.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumberOfSquarefulArrays {

    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        if (n == 1) return 0;
        boolean[] visited = new boolean[n];
        return helper(0, A, -1, visited);
    }

    int helper(int count, int[] arr, int prevIdx, boolean[] visited) {
        if (count == arr.length) return 1;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            /*What in the world is this!?*/
            if (!visited[i] && (i == 0 || (arr[i] != arr[i - 1] || visited[i - 1])) && (prevIdx == -1 || isPerfect(arr[prevIdx], arr[i]))) {
                visited[i] = true;
                ans += helper(count + 1, arr, i, visited);
                visited[i] = false;
            }
        }
        return ans;
    }

    boolean isPerfect(int num1, int num2) {
        long sum = num1 + num2;
        int root = (int) Math.sqrt(sum);
        return (long) root * root == sum;
    }

    /**
     * Solution 2 (Easier to understand) -
     */

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        return squareful(0, new ArrayList<>(), map, n);
    }

    private int squareful(int index, ArrayList<Integer> arrangement, HashMap<Integer, Integer> map, int n) {
        if (n == index) return 1;
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                if (index == 0) {
                    arrangement.add(key);
                    map.put(key, map.get(key) - 1);
                    ans += squareful(index + 1, arrangement, map, n);
                    map.put(key, map.get(key) + 1);
                    arrangement.remove(arrangement.size() - 1);
                } else {
                    int sum = key + arrangement.get(index - 1);
                    int sqrt = (int) Math.sqrt(sum);
                    if (sum == sqrt * sqrt) {
                        arrangement.add(key);
                        map.put(key, map.get(key) - 1);
                        ans += squareful(index + 1, arrangement, map, n);
                        map.put(key, map.get(key) + 1);
                        arrangement.remove(arrangement.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

}
