package advanced.hashing;

import java.util.Map;
import java.util.TreeMap;

public class SortArrayInGivenOrder {

    public int[] solve(int[] A, int[] B) {
        int nA = A.length;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0; i<nA; i++) {
            tm.put(A[i], tm.getOrDefault(A[i], 0) + 1);
        }

        int idx = 0;
        for(int num : B) {
            if(tm.containsKey(num)) {
                A[idx++] = num;
                tm.put(num, tm.get(num) - 1);
                if(tm.get(num) == 0) tm.remove(num);
            }
        }

        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int count = entry.getValue();
            while(count > 0) {
                A[idx++] = entry.getKey();
                count--;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        SortArrayInGivenOrder obj = new SortArrayInGivenOrder();
        int[] A = new int[] {1, 2, 3, 4, 5};
        int[] B = new int[] {5, 4, 2};
        int[] ans = obj.solve(A, B);
        for(int n : ans) System.out.print(n + " ");
    }

}
