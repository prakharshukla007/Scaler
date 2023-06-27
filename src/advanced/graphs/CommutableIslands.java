package advanced.graphs;

import java.util.Arrays;
import java.util.Comparator;

public class CommutableIslands {

    public int solve(int A, int[][] B) {
        Arrays.sort(B, Comparator.comparingInt(a -> a[2]));
        int[] parent = new int[A+1];

        for(int i=1; i<=A; i++) parent[i] = i;

        int ans = 0;

        for(int i=0; i<B.length; i++) {
            int x = findParent(parent, B[i][0]);
            int y = findParent(parent, B[i][1]);

            if(x != y) {
                parent[y] = x;
                ans += B[i][2];
            }
        }

        return ans;
    }

    public int findParent(int[] parent, int i) {
        if(i == parent[i]) return i;

        parent[i] = findParent(parent, parent[i]);
        return parent[i];
    }

}
