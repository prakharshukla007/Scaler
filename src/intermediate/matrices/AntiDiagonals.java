package intermediate.matrices;

import java.util.ArrayList;

public class AntiDiagonals {

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>(2 * n - 1);
        for(int i=0; i<2*n-1; i++) {
            ArrayList<Integer> ls = new ArrayList<>(n);
            res.add(ls);
        }

        int diagCount = 0;

        for(int col=0; col<m; col++) {
            int j = col;
            int i = 0;
            int idx = 0;
            while(i < n && j >= 0) {
                res.get(diagCount).set(idx++, A.get(i).get(j));
                i++;
                j--;
            }
            diagCount++;
        }

        for(int row=1; row<n; row++) {
            int i = row;
            int j = m-1;
            int idx = 0;
            while(i < n && j >= 0) {
                res.get(diagCount).set(idx++, A.get(i).get(j));
                i++;
                j--;
            }
            diagCount++;
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>(2);
        int i = 1;
        for(int j=0; j<2; j++) {
            ArrayList<Integer> ls1 = new ArrayList<>();
            ls1.add(i++);
            ls1.add(i++);
            ls.add(ls1);
        }
        ArrayList<Integer> l = new ArrayList<>(2);
        l.get(1);
        System.out.println(diagonal(ls));
    }

}
