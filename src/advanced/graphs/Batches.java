package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Batches {

    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        ArrayList<Integer>[] adjList = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adjList[i] = new ArrayList<>();

        for(ArrayList<Integer> relation : C) {
            adjList[relation.get(0)].add(relation.get(1));
            adjList[relation.get(1)].add(relation.get(0));
        }

        boolean[] visited = new boolean[A+1];
        int ans = 0;
        for(int i=1; i<=A; i++) {
            if(!visited[i]) {
                int sum = bfs(i, visited, adjList, B);
                if(sum >= D) ans++;
            }
        }

        return ans;
    }

    public int bfs(int start, boolean[] visited, ArrayList<Integer>[] adjList, ArrayList<Integer> B) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sum += B.get(cur-1);
            for(int v : adjList[cur]) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        C.add(new ArrayList<>(List.of(1, 2)));
        C.add(new ArrayList<>(List.of(2, 3)));
        C.add(new ArrayList<>(List.of(5, 6)));
        C.add(new ArrayList<>(List.of(5, 7)));

        ArrayList<Integer> B = new ArrayList<>(List.of(1, 6, 7, 2, 9, 4, 5));

        System.out.println(new Batches().solve(7, B, C, 12));
    }

}
