package advanced.backtracking;

import java.util.ArrayList;

public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans2 = new ArrayList<>();

        ArrayList<Integer> cols = new ArrayList<>();
        for(int i=0; i<A; i++) cols.add(-1);

        nQueen(0, A, cols, ans2);
        System.out.println(ans2);

        for(int r=0; r<ans2.size(); r++) {
            ArrayList<String> lsStr = new ArrayList<>();
            for(int col=0; col<A; col++) {
                int mainIdx = ans2.get(r).get(col);
                String str = "";
                for(int i=0; i<A; i++) {
                    if(i == mainIdx) str += "Q";
                    else str += ".";
                }
                lsStr.add(str);
            }
            ans.add(lsStr);
        }

        if(ans.size() == 0) return new ArrayList<>();
        return ans;
    }

    private void nQueen(int r, int n, ArrayList<Integer> col, ArrayList<ArrayList<Integer>> res) {
        if(r == n) {
            res.add(new ArrayList<>(col));
            return;
        }

        for(int c = 0; c<n; c++) {
            if(isValid(r, c, col)) {
                col.set(r, c);
                nQueen(r+1, n, col, res);
                col.set(r, -1);
            }
        }
    }

    private boolean isValid(int r, int c, ArrayList<Integer> col) {
        for(int i=0; i<r; i++) {
            if(check(r, c, i, col.get(i))) return false;
        }
        return true;
    }

    private boolean check(int r1, int c1, int r2, int c2) {
        return (c1 == c2) || (r1 == r2) || ((r1 - c1) == (r2-c2)) || ((r1+c1) == (r2+c2));
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(2));
        System.out.println(Character.forDigit(15, 16));
    }

}
