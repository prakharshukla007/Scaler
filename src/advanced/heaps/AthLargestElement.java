package advanced.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AthLargestElement {

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<A; i++) {
            if(i < A-1) ans.add(-1);
            else ans.add(minHeap.peek());
            minHeap.add(B.get(i));
        }
        for(int i=A; i<B.size(); i++) {
            if(B.get(i) > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(B.get(i));
            }
            ans.add(minHeap.peek());
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(new AthLargestElement().solve(4, ls));
    }

}
