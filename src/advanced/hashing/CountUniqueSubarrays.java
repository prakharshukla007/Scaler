package advanced.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountUniqueSubarrays {

    public int solve3(int[] A) {
        Set<Integer> S = new HashSet<>();
        long count = 0L;
        int i = 0;
        int j = 0 ;
        while(j < A.length) {
            if(S.contains(A[j])) {
                S.remove(A[i]);
                i++;
            } else {
                S.add(A[j]);
                count += j - i + 1;
                j++;
            }
        }
        return (int)(count % 1000000007);
    }

    public int solve2(int[] A) {
        int n = A.length;
        long count = 0L;

        for(int i=0; i<n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i; j<n; j++) {
                if(hs.contains(A[j])) break;
                hs.add(A[j]);
                count++;
            }
        }

        return (int)(count % 1000000007);
    }

    public int solve(int[] A) {
        int n = A.length;
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int k=i; k<n; k++) {
                HashSet<Integer> hs = new HashSet<>();
                boolean isUnique = true;
                for (int j = i; j <= k; j++) {
                    if (hs.contains(A[j])) {
                        isUnique = false;
                        break;
                    }
                    hs.add(A[j]);
                }
                if(isUnique) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63};
        int[] arr2 = new int[] {1, 1, 3};
        System.out.println(new CountUniqueSubarrays().solve2(arr));
    }

}
