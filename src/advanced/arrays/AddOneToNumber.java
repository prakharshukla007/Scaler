package advanced.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = A.size() - 1;
        int n = A.get(i) + 1;
        boolean carry;
        if (n == 10) {
            carry = true;
            A.set(i, 0);
        } else {
            A.set(i, n);
            removeZeroesAtHead(A);
            return A;
        }

        i--;
        while (carry && i >= 0) {
            int n1 = A.get(i) + 1;
            if (n1 != 10) {
                carry = false;
                A.set(i, n1);
            } else {
                A.set(i, 0);
            }
            i--;
        }

        if (carry && i == -1) A.add(0, 1);

        removeZeroesAtHead(A);

        return A;
    }

    public void removeZeroesAtHead(ArrayList<Integer> ar) {
        while (!ar.isEmpty()) {
            if (ar.get(0) != 0) break;
            else ar.remove(0);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>(List.of(0, 3, 7, 6, 4, 0, 5, 5, 5));
        System.out.println(new AddOneToNumber().plusOne(ar));
    }

}
