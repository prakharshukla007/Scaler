package personal.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void bfs(ArrayList<Integer>[] adjMatrix, int v) {
        boolean[] visited = new boolean[v+1];

        for(int i=1; i<=v; i++) {
            if(!visited[i]) bfsUtil(adjMatrix, visited, i);
        }
    }

    public void bfsUtil(ArrayList<Integer>[] adjMatrix, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()) {
            s = queue.poll();
            for(int v : adjMatrix[s]) {
                if(!visited[v]) {
                    visited[v] = true;
                    System.out.print(v + " ");
                    queue.add(v);
                }
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

        new BFS().bfs(adjMatrix, 5);
    }

}
