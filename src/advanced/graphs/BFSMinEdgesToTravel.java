package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSMinEdgesToTravel {

    public int bfs(ArrayList<ArrayList<Integer>> edges, int start, int end, int n) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++) adjList[i] = new ArrayList<>();

        for(ArrayList<Integer> edge : edges) {
            adjList[edge.get(0)].add(edge.get(1));
            adjList[edge.get(1)].add(edge.get(0));
        }

        return bfsUtil(adjList, start, end, n);
    }

    public int bfsUtil(ArrayList<Integer>[] adjList, int start, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        dist[start] = 0;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == end) return dist[cur];
            for(int v : adjList[cur]) {
                if(!visited[v]) {
                    dist[v] = dist[cur] + 1;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(0, 3)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(2, 3)));
        edges.add(new ArrayList<>(List.of(2, 4)));
        edges.add(new ArrayList<>(List.of(2, 5)));
        edges.add(new ArrayList<>(List.of(3, 4)));
        edges.add(new ArrayList<>(List.of(4, 5)));

        System.out.println(new BFSMinEdgesToTravel().bfs(edges, 0, 4, 6));
    }

}
