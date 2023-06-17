package advanced.graphs;

import java.util.ArrayList;
import java.util.List;

public class PathInDirectedGraph {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] adjList = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adjList[i] = new ArrayList<>();
        for(ArrayList<Integer> ls : B) {
            adjList[ls.get(0)].add(ls.get(1));
        }

        boolean[] visited = new boolean[A+1];
        findPathDfs(adjList, visited, 1);

        if(visited[A]) return 1;
        return 0;
    }

    private void findPathDfs(ArrayList<Integer>[] adjList, boolean[] visited, int start) {
        visited[start] = true;
        for(int v : adjList[start]) {
            if(!visited[v]) findPathDfs(adjList, visited, v);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(1, 2)));
        B.add(new ArrayList<>(List.of(4, 1)));
        B.add(new ArrayList<>(List.of(2, 4)));
        B.add(new ArrayList<>(List.of(3, 4)));
        B.add(new ArrayList<>(List.of(5, 2)));
        B.add(new ArrayList<>(List.of(1, 3)));

        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(List.of(1, 2)));
        B2.add(new ArrayList<>(List.of(2, 3)));
        B2.add(new ArrayList<>(List.of(3, 4)));
        B2.add(new ArrayList<>(List.of(4, 5)));

        System.out.println(new PathInDirectedGraph().solve(5, B2));
    }

}
