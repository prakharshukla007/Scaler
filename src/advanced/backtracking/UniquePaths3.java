package advanced.backtracking;

import java.util.ArrayList;

public class UniquePaths3 {

    int p = 0;

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int count = 0, start = 0, end = 0;
        int[][] pointer = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (A.get(i).get(j) == 0)
                    count++;
                if (A.get(i).get(j) == 1) {
                    start = i;
                    end = j;
                }
            }
        }
        check(A, pointer, start, end, 0, count + 1);
        return p;
    }

    void check(ArrayList<ArrayList<Integer>> A, int[][] pointer, int start, int end, int count, int ans) {
        if (start < 0 || start >= A.size() || end < 0 || end >= A.get(0).size())
            return;

        if (A.get(start).get(end) == 2) {
            if (count == ans)
                p++;
            return;
        }
        if (A.get(start).get(end) == -1)
            return;
        if (pointer[start][end] == 1)
            return;
        pointer[start][end] = 1;

        check(A, pointer, start, end + 1, count + 1, ans);
        check(A, pointer, start - 1, end, count + 1, ans);
        check(A, pointer, start + 1, end, count + 1, ans);
        check(A, pointer, start, end - 1, count + 1, ans);

        pointer[start][end] = 0;
    }

}
