package intermediate.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MultipleLeftRotations {

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int n1 : B) {
            res.add(rotate(A, n1));
        }
        return res;
    }

    public static ArrayList<Integer> rotate(ArrayList<Integer> ls, int count) {
        ArrayList<Integer> ls2 = new ArrayList<>(ls);
        Collections.reverse(ls2);
        reverse(ls2, 0, ls.size()-count-1);
        reverse(ls2, ls.size()-count, ls.size()-1);
        return ls2;
    }

    public static void reverse(ArrayList<Integer> ls, int a, int b) {
        int i = a;
        int j = b;
        while(i < j) {
            int temp = ls.get(i);
            ls.set(i, ls.get(j));
            ls.set(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 3));
        System.out.println(solve(A, B));
    }

}
