package advanced.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int median = A.get(0);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        for(int n : A) {
            if(n <= median) {
                maxHeap.add(n);
                if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
                }
            }
            else {
                minHeap.add(n);
                if(minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
            median = maxHeap.peek();
            ans.add(median);
        }
        return ans;
    }

}
