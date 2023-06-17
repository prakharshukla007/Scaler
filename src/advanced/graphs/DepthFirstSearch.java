package advanced.graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public void dfs(ArrayList<ArrayList<Integer>> edges, int v) {
        ArrayList<Integer>[] adjList = new ArrayList[v+1];
        for(int i=0; i<=v; i++) adjList[i] = new ArrayList<>();
        for(ArrayList<Integer> edge : edges) {
            adjList[edge.get(0)].add(edge.get(1));
        }
        boolean[] visited = new boolean[v+1];
        for(int i=1; i<=v; i++) {
            if(!visited[i]) dfsUtil(adjList, visited, i);
        }
    }

    public void dfsUtil(ArrayList<Integer>[] adjList, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int v : adjList[start]) {
            if(!visited[v]) dfsUtil(adjList, visited, v);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(1, 3)));
        B.add(new ArrayList<>(List.of(4, 1)));
        B.add(new ArrayList<>(List.of(4, 2)));
        B.add(new ArrayList<>(List.of(3, 4)));
        B.add(new ArrayList<>(List.of(5, 2)));
        B.add(new ArrayList<>(List.of(1, 2)));

        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(List.of(1, 2)));
        B2.add(new ArrayList<>(List.of(2, 3)));
        B2.add(new ArrayList<>(List.of(3, 4)));
        B2.add(new ArrayList<>(List.of(4, 5)));

        new DepthFirstSearch().dfs(B, 5);
    }

}
