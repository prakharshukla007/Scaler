package tct_1;

import java.util.ArrayList;

public class InversionCountInArray {
    int mod = 1000000007;
    public int solve(ArrayList<Integer> A) {
        return mergeSortWithCount(A, 0, A.size()-1);
    }
    public int mergeSortWithCount(ArrayList<Integer> A, int l, int r) {
        long count = 0;
        if(l < r) {
            int mid = (l + r)/2;

            count = (count + mergeSortWithCount(A, l, mid)) % mod;
            count = (count + mergeSortWithCount(A, mid+1, r)) % mod;
            count = (count + mergeAndCount(A, l, mid, r)) % mod;
        }
        return (int) count;
    }
    public int mergeAndCount(ArrayList<Integer> A, int l, int mid, int r) {
        ArrayList<Integer> leftArr = new ArrayList<>(A.subList(l, mid+1));
        ArrayList<Integer> rightArr = new ArrayList<>(A.subList(mid+1, r+1));

        int i = 0, j = 0, idx = l;
        long swaps = 0;
        while(i < leftArr.size() && j < rightArr.size()) {
            if(leftArr.get(i) <= rightArr.get(j)) {
                A.set(idx++, leftArr.get(i++));
            } else {
                A.set(idx++, rightArr.get(j++));
                swaps = (swaps + mid - (l + i) + 1) % mod;
            }
        }

        while(i < leftArr.size()) A.set(idx++, leftArr.get(i++));
        while(j < rightArr.size()) A.set(idx++, rightArr.get(j++));

        return (int) (swaps % mod);
    }
}
