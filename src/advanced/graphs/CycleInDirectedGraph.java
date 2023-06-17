package advanced.graphs;

import java.util.ArrayList;

public class CycleInDirectedGraph {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] adjList = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adjList[i] = new ArrayList<>();

        for(ArrayList<Integer> ls : B) adjList[ls.get(0)].add(ls.get(1));

        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1];

        for(int i=1; i<=A; i++) {
            if(!visited[i] && checkCycleDfs(adjList, visited, path, i)) return 1;
        }

        return 0;
    }

    private boolean checkCycleDfs(ArrayList<Integer>[] adjList, boolean[] visited, boolean[] path, int start) {
        visited[start] = true;
        path[start] = true;

        for(int v : adjList[start]) {
            if(path[v]) return true;
            if(!visited[v] && checkCycleDfs(adjList, visited, path, v)) return true;
        }

        path[start] = false;
        return false;
    }

}
