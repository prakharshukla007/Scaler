package advanced.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TheShipCompany {

    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(C);
        ans.add(totalCost(maxHeap, A));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(C);
        ans.add(totalCost(minHeap, A));
        return ans;
    }

    public int totalCost(PriorityQueue<Integer> pQ, int A) {
        int count = 0;
        int cost = 0;
        while(count < A && !pQ.isEmpty()) {
            int temp = pQ.poll();
            count++;
            cost += temp--;
            if(temp != 0) pQ.add(temp);
        }
        return cost;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(2, 1, 1));
        System.out.println(new TheShipCompany().solve(4, 3, ls));
    }

}
