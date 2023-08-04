package advanced.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueElements {

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int count = 0;

        for(int i=1; i<A.size(); i++) {
            if(A.get(i) == A.get(i-1)) {
                A.set(i, A.get(i) + 1);
                count++;
            } else if(A.get(i) < A.get(i-1)) {
                count += (A.get(i-1) + 1) - A.get(i);
                A.set(i, A.get(i-1) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(2, 4, 3, 4, 5, 3));
        System.out.println(new UniqueElements().solve(ls));
    }

}
