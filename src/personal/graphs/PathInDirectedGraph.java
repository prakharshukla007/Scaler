package personal.graphs;

import java.util.ArrayList;

public class PathInDirectedGraph {
    int ans = 0;
    public int solve(int A, int[][] B) {
        ArrayList<Integer>[] adj = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<B.length; i++) {
            adj[B[i][0]].add(B[i][1]);
        }

        boolean[] visited = new boolean[A+1];
        util(adj, visited, 1, A);
        return ans;
    }

    public void util(ArrayList<Integer>[] adj, boolean[] visited, int s, int A) {
        visited[s] = true;
        for(int v : adj[s]) {
            if(v == A) {
                ans = 1;
            }
            if(!visited[v]) {
                visited[v] = true;
                util(adj, visited, v, A);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[3][];
        edges[0] = new int[] {1, 2};
        edges[1] = new int[] {2, 3};
        edges[2] = new int[] {3, 1};

        System.out.println(new PathInDirectedGraph().solve(3, edges));
    }

}
