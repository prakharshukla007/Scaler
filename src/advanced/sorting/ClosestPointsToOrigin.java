package advanced.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClosestPointsToOrigin {

    public class PointComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if(distanceFromOrigin(o1) > distanceFromOrigin(o2)) return 1;
            else if(distanceFromOrigin(o1) < distanceFromOrigin(o2)) return -1;
            else return 0;
        }
    }

    public int distanceFromOrigin(ArrayList<Integer> ls) {
        return (int) Math.sqrt(Math.pow(ls.get(0), 2) + Math.pow(ls.get(1), 2));
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        Collections.sort(A, new PointComparator());
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<B; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }



}
