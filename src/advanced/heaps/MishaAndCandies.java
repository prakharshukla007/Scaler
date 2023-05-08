package advanced.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MishaAndCandies {

    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.addAll(A);
        int count = 0;
        while(!pQ.isEmpty()) {
            int num1 = pQ.poll();
            if(num1 <= B) {
                count += num1/2;
                if(!pQ.isEmpty()) {
                    int num2 = pQ.poll();
                    num2 += num1 - num1/2;
                    pQ.add(num2);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls;
        ls = new ArrayList<>(List.of(1, 2, 1));
        System.out.println(new MishaAndCandies().solve(ls, 2));
    }

}
