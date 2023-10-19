package personal.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public void dfs(ArrayList<Integer>[] adjMatrix, int v) {
        boolean[] visited = new boolean[v+1];

        for(int i=1; i<=v; i++) {
            if(!visited[i]) {
                dfsUtil(adjMatrix, visited, i);
            }
        }
    }

    public void dfsUtil(ArrayList<Integer>[] adjMatrix, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        for(int v : adjMatrix[s]) {
            if(!visited[v]) {
                dfsUtil(adjMatrix, visited, v);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] adjMatrix = new ArrayList[6];
        adjMatrix[1] = new ArrayList<>(List.of(2, 3, 4));
        adjMatrix[2] = new ArrayList<>(List.of(5));
        adjMatrix[3] = new ArrayList<>(List.of(4));
        adjMatrix[4] = new ArrayList<>(List.of(2));
        adjMatrix[5] = new ArrayList<>();

        new DFS().dfs(adjMatrix, 5);
    }

}
