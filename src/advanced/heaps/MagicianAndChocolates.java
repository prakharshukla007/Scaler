package advanced.heaps;

import java.util.ArrayList;

public class MagicianAndChocolates {

    public int nchoc(int A, ArrayList<Integer> B) {
        for(int i=(B.size()-2)/2; i>=0; i--) {
            heapify(B, i);
        }

        long ans = 0;
        int mod = 1000000007;
        while(A > 0) {
            ans += B.get(0);
            ans %= mod;
            B.set(0, B.get(0)/2);
            heapify(B, 0);
            A--;
        }

        return (int) ans;
    }

    public void heapify(ArrayList<Integer> A, int i) {
        int idx = i;
        int n = A.size();
        while(idx < n) {
            int LC = 2 * idx + 1;
            int RC = 2 * idx + 2;
            int maxC = -1;
            boolean flag = true;
            if(LC >= n) flag = false;
            else {
                if(RC >= n) {
                    if(A.get(LC) > A.get(idx)) maxC = LC;
                    else flag = false;
                }
                else if(A.get(idx) > A.get(LC) && A.get(idx) > A.get(LC)) flag = false;
                else {
                    if(A.get(LC) > A.get(RC)) maxC = LC;
                    else maxC = RC;
                }
            }

            if(!flag) break;
            swap(A, maxC, idx);
            idx = maxC;
        }
    }

    private void swap(ArrayList<Integer> arr, int idx1, int idx2) {
        int temp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, temp);
    }

}
