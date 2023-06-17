package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public void bfs(ArrayList<ArrayList<Integer>> edges, int v) {
        ArrayList<Integer>[] adjList = new ArrayList[v+1];
        for(int i=0; i<=v; i++) adjList[i] = new ArrayList<>();
        for(ArrayList<Integer> edge : edges) {
            adjList[edge.get(0)].add(edge.get(1));
        }

        boolean[] visited = new boolean[v+1];
        for(int i=1; i<=v; i++) {
            if(!visited[i]) bfsUtil(adjList, visited, i);
        }
    }

    public void bfsUtil(ArrayList<Integer>[] adjList, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while(!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");
            for(int v1 : adjList[v]) {
                if(!visited[v1]) {
                    visited[v1] = true;
                    queue.add(v1);
                }
            }
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

        new BreadthFirstSearch().bfs(B, 5);
    }

}
