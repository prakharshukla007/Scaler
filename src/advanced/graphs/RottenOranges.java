package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    public class Pair {
        int i;
        int j;
        int time;
        public Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    int countOne = 0;

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(A.get(i).get(j) == 1) countOne++;
                if(A.get(i).get(j) == 2) queue.add(new Pair(i, j, 0));
            }
        }

        int ans = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            int i = cur.i;
            int j = cur.j;

            if(i >= 0 && j >= 0 && i < n && j < m) {
                for(int k=0; k<4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if(ni >= 0 && nj >= 0 && ni < n && nj < m && A.get(ni).get(nj) == 1) {
                        A.get(ni).set(nj, 2);
                        queue.add(new Pair(ni, nj, cur.time+1));
                        countOne--;
                        ans = Math.max(ans, cur.time+1);
                    }
                }
            }
        }

        if(countOne != 0) return -1;
        countOne = 0;
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(2, 1, 1)));
        A.add(new ArrayList<>(List.of(1, 1, 0)));
        A.add(new ArrayList<>(List.of(0, 1, 1)));

        System.out.println(new RottenOranges().solve(A));
    }

}
