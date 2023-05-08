package advanced.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BClosestPointsToOrigin {

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class PointsComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            int dist1 = o1.x * o1.x + o1.y * o1.y;
            int dist2 = o2.x * o2.x + o2.y * o2.y;

            return Integer.compare(dist1, dist2);
        }
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new PointsComparator());
        for(ArrayList<Integer> pair : A) {
            minHeap.add(new Pair(pair.get(0), pair.get(1)));
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int count = 0;
        while(count < B) {
            Pair temp = minHeap.poll();
            result.add(new ArrayList<>(List.of(temp.x, temp.y)));
            count++;
        }
        return result;
    }

}
