package intermediate.arrays;

import java.util.ArrayList;

public class ReverseInRange {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
        while(B < C) {
            swap(A, B, C);
            B++;
            C--;
        }
        return A;
    }
    public static void swap(ArrayList<Integer> ls, int p1, int p2) {
        int temp = ls.get(p1);
        ls.set(p1, ls.get(p2));
        ls.set(p2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        solve(ls, 2, 3);
        System.out.println(ls);
    }

}
