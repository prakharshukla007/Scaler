package advanced.arrays;

import java.util.ArrayList;
import java.util.List;

public class ContinuousSumQuery {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> newB = new ArrayList<>();
        for(ArrayList<Integer> ls : B) {
            if(ls.get(1) == A) {
                newB.add(new ArrayList<>(List.of(ls.get(0), ls.get(2))));
                continue;
            }
            newB.add(new ArrayList<>(List.of(ls.get(0), ls.get(2))));
            newB.add(new ArrayList<>(List.of(ls.get(1)+1, ls.get(2) * (-1))));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<A; i++) ans.add(0);
        for(ArrayList<Integer> ls : newB) {
            int idx = ls.get(0)-1;
            int x = ls.get(1);
            ans.set(idx, ans.get(idx)+x);
        }

        for(int i=1; i<A; i++) {
            ans.set(i, ans.get(i) + ans.get(i-1));
        }

        return ans;
    }

    public ArrayList<Integer> removeZeroesAtHead(ArrayList<Integer> ar) {
        while(!ar.isEmpty()) {
            if(ar.get(0) != 0) break;
            else ar.remove(0);
        }
        return ar;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(1, 2, 10)));
        B.add(new ArrayList<>(List.of(2, 3, 20)));
        B.add(new ArrayList<>(List.of(2, 5, 25)));

        System.out.println(new ContinuousSumQuery().solve(5, B));

        ArrayList<Integer> ar = new ArrayList<>(List.of(0, 1, 2, 3));
        System.out.println(new ContinuousSumQuery().removeZeroesAtHead(ar));
    }

}
