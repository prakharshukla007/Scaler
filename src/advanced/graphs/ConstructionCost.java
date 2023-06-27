package advanced.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructionCost {

    public class Pair {
        int node;
        int w;
        public Pair(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public class NodeComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.w - o2.w;
        }
    }

    public int solve(int A, int[][] B) {
        int m = 1000000007;
        PriorityQueue<Pair> pQ = new PriorityQueue<>(new NodeComparator());

        ArrayList<Pair>[] adjList = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adjList[i] = new ArrayList<>();

        for(int[] edge : B) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            adjList[x].add(new Pair(y, w));
            adjList[y].add(new Pair(x, w));
        }

        long totalSum = 0;

        boolean[] visited = new boolean[A+1];
        visited[1] = true;

        for(Pair p : adjList[1]) pQ.add(p);

        while(!pQ.isEmpty()) {
            Pair cur = pQ.poll();
            if(visited[cur.node]) continue;
            visited[cur.node] = true;
            totalSum = (totalSum + cur.w) % m;
            for(Pair p : adjList[cur.node]) {
                if(!visited[p.node]) pQ.add(new Pair(p.node, p.w));
            }
        }

        return (int) (totalSum % m);
    }

}
