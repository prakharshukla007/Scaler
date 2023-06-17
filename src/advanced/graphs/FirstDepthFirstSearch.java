package advanced.graphs;

import java.util.ArrayList;
import java.util.List;

public class FirstDepthFirstSearch {

    public int solve(ArrayList<Integer> A, final int B, final int C) {
        int n = A.size();
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for(int i=0; i<=n; i++) adjList[i] = new ArrayList<>();
        for(int i=1; i<n; i++) {
            adjList[A.get(i)].add(i+1);
        }

        boolean[] visited = new boolean[n+1];
        dfs(adjList, visited, C);

        if(visited[B]) return 1;
        return 0;
    }

    public void dfs(ArrayList<Integer>[] adjList, boolean[] visited, int start) {
        visited[start] = true;
        for(int v : adjList[start]) {
            if(!visited[v]) dfs(adjList, visited, v);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(1, 1, 2));
        System.out.println(new FirstDepthFirstSearch().solve(ls, 2, 1));
    }

}
