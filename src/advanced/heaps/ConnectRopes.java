package advanced.heaps;

import java.util.ArrayList;
import java.util.List;

public class ConnectRopes {

    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int n : A) {
            createHeap(ls, n);
        }
        int ans = 0;
        while (ls.size() > 0) {
            if(ls.size() == 1) {
                return ans;
            }
            else {
                int rope1 = getAndRemoveMin(ls);
                int rope2 = getAndRemoveMin(ls);
                ans += rope1 + rope2;
                createHeap(ls, rope1 + rope2);
            }
        }

        return ans;
    }

    public void createHeap(ArrayList<Integer> ls, int n) {
        ls.add(n);
        int i = ls.size() - 1;
        while ((i - 1) / 2 >= 0 && ls.get((i - 1) / 2) > ls.get(i)) {
            swap(ls, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    public int getAndRemoveMin(ArrayList<Integer> heap) {
        if (heap.size() == 1) return heap.remove(0);
        int ans = heap.remove(0);
        heap.add(0, heap.remove(heap.size() - 1));
        int i = 0;
        int n = heap.size();
        while (i < n) {
            int LC = 2 * i + 1;
            int RC = 2 * i + 2;
            boolean flag = true;
            int minC = -1;
            if (LC >= n) flag = false;
            else {
                if (RC >= n) {
                    if (heap.get(LC) < heap.get(i)) minC = LC;
                    else flag = false;
                } else if (heap.get(LC) > heap.get(i) && heap.get(RC) > heap.get(i)) flag = false;
                else {
                    if (heap.get(LC) < heap.get(RC)) minC = LC;
                    else minC = RC;
                }
            }
            if (!flag) break;
            swap(heap, minC, i);
            i = minC;
        }
        return ans;
    }

    public void heapify(ArrayList<Integer> A, int i) {
        int idx = i;
        int n = A.size();
        while (idx < n) {
            int LC = 2 * idx + 1;
            int RC = 2 * idx + 2;
            boolean flag = true;
            int minC = -1;
            if (LC >= n) flag = false;
            else {
                if (RC >= n) {
                    if (A.get(LC) < A.get(idx)) minC = LC;
                    else flag = false;
                } else if (A.get(LC) > A.get(idx) && A.get(RC) > A.get(idx)) flag = false;
                else {
                    if (A.get(LC) < A.get(RC)) minC = LC;
                    else minC = RC;
                }
            }
            if (!flag) break;
            swap(A, minC, idx);
            idx = minC;
        }
    }

    private void swap(ArrayList<Integer> A, int idx1, int idx2) {
        int temp = A.get(idx1);
        A.set(idx1, A.get(idx2));
        A.set(idx2, temp);
    }

    public static void main(String[] args) {
        System.out.println(new ConnectRopes().solve(new ArrayList<>(List.of(1, 18))));
    }

}
