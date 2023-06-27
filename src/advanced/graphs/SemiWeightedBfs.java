package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SemiWeightedBfs {

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        ArrayList<ArrayList<Integer>> newB = new ArrayList<>();

        int extra = 0;
        for(ArrayList<Integer> edge : B) {
            if(edge.get(2) == 2) {
                newB.add(new ArrayList<>(List.of(edge.get(0), A+extra)));
                newB.add(new ArrayList<>(List.of(edge.get(1), A+extra++)));
            }
            else {
                newB.add(edge);
            }
        }

        int newSize = A+extra;
        ArrayList<Integer>[] adjList = new ArrayList[newSize];
        for(int i=0; i<newSize; i++) adjList[i] = new ArrayList<>();

        for(ArrayList<Integer> edge : newB) {
            adjList[edge.get(0)].add(edge.get(1));
            adjList[edge.get(1)].add(edge.get(0));
        }

        return bfs(adjList, C, D, newSize);
    }

    public int bfs(ArrayList<Integer>[] adjList, int start, int end, int newSize) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[newSize];
        dist[start] = 0;
        boolean[] visited = new boolean[newSize];
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
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(2, 5, 1)));
        B.add(new ArrayList<>(List.of(1, 3, 1)));
        B.add(new ArrayList<>(List.of(0, 5, 2)));
        B.add(new ArrayList<>(List.of(0, 2, 2)));
        B.add(new ArrayList<>(List.of(1, 4, 1)));
        B.add(new ArrayList<>(List.of(0, 1, 1)));

        System.out.println(new SemiWeightedBfs().solve(6, B, 3, 2));
    }

}
