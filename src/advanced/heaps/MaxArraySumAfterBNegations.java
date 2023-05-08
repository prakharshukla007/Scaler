package advanced.heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxArraySumAfterBNegations {

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;

        //First pass to negate negative elements with the highest magnitude.
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> Math.abs(b) - Math.abs(a));
        pQ.addAll(A);
        ArrayList<Integer> ls1 = new ArrayList<>();
        while(!pQ.isEmpty()) {
            int num = pQ.poll();
            if(num < 0 && count != B) {
                num *= -1;
                count++;
            }
            ls1.add(num);
        }

        if(count == B) {
            int sum = 0;
            for(int n : ls1) sum += n;
            return sum;
        }

        //Second pass to negate the smallest numbers
        pQ = new PriorityQueue<>();
        pQ.addAll(ls1);
        int min = pQ.poll();
        while(count != B) {
            min *= -1;
            count++;
        }
        pQ.add(min);

        int sum = 0;
        while(!pQ.isEmpty()) {
            sum += pQ.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(-75, 89, 77, 57, 9, -98, -33));
        System.out.println(new MaxArraySumAfterBNegations().solve(ls, 2));
    }

}
