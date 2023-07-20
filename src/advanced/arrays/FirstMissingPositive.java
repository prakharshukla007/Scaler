package advanced.arrays;

import java.util.*;

public class FirstMissingPositive {

    public static int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        int i = 0;
        while(i < n) {
            if(A.get(i) < 1 || A.get(i) > i || A.get(i) == i+1)
                i++;
            else {
                int idx = A.get(i) - 1;
                if(A.get(idx) != A.get(i))
                    swap(A, i, idx);
                else
                    i++;
            }
        }

        for(i=0; i<n; i++) {
            if(A.get(i) != i+1) return i+1;
        }

        return n+1;
    }

    public static void swap(ArrayList<Integer> ls, int i, int j) {
        int temp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }

    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for(int i=0; i<A.size(); i++) {
            if(hm.containsKey(B - A.get(i))) {
                count++;
            } else {
                hm.put(A.get(i), i);
            }
        }
        return count;
    }

    public Long solve2(ArrayList<Integer> A, int B) {
        long maxWt = -1L;
        for(int i=0; i<A.size(); i++) {
            maxWt = Math.max(maxWt, A.get(i));
        }

        int count = 1;

        int i = 0;
        Long runningSum = 0L;
        while(i < A.size()) {
            if(runningSum + A.get(i) > maxWt) {
                if(count < B) {
                    count++;
                    runningSum = 0L;
                } else {
                    break;
                }
            } else {
                runningSum += A.get(i);
                i++;
            }
        }

        Long sum2 = 0L;
        if(i != A.size()) {
            i--;
            while(i < A.size()) {
                sum2 += A.get(i++);
            }
        }

        if(sum2 != 0L) return Math.max(runningSum, sum2);
        else return maxWt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(0, 3, 1, 2));
        System.out.println(firstMissingPositive(ls));

        ArrayList<Integer> A = new ArrayList<>(List.of(25, 24, 9, 6, 23, 20, 4, 10));
        System.out.println(new FirstMissingPositive().solve(A, 16));

        ArrayList<Integer> ls2 = new ArrayList<>(List.of(10, 6, 5));
        System.out.println(new FirstMissingPositive().solve2(ls2, 2));
    }

}
