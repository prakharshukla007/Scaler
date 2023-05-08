package advanced.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPlacesApart {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int idx = 0;
        while(idx <= B) {
            pQ.add(A.get(idx++));
        }
        for(int i=0; i<A.size(); i++) {
            A.set(i, pQ.poll());
            if(idx < A.size())
                pQ.add(A.get(idx++));
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(2, 1, 17, 10, 21, 95));
        System.out.println(new KPlacesApart().solve(ls, 1));
    }

}
