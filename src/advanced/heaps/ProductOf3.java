package advanced.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ProductOf3 {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            if(i == 0 || i == 1) {
                pQ.add(A.get(i));
                ans.add(-1);
            }
            else {
                pQ.add(A.get(i));
                int prod = 1;
                int num1 = pQ.poll();
                int num2 = pQ.poll();
                int num3 = pQ.poll();
                prod = num1 * num2 * num3;
                pQ.add(num1);
                pQ.add(num2);
                pQ.add(num3);
                ans.add(prod);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(10, 2, 3));
        System.out.println(new ProductOf3().solve(ls));
    }

}
