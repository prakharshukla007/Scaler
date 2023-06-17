package advanced.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopologicalSort {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] adjList = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adjList[i] = new ArrayList<>();

        for(ArrayList<Integer> edge : B) adjList[edge.get(0)].add(edge.get(1));

        int[] indegree = new int[A+1];
        for(int u=1; u<=A; u++) {
            for(int v : adjList[u]) indegree[v]++;
        }
        int countVisited = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i=1; i<=A; i++) {
            if(indegree[i] == 0) pQ.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!pQ.isEmpty()) {
            int cur = pQ.poll();
            ans.add(cur);
            countVisited++;
            for(int v : adjList[cur]) {
                indegree[v]--;
                if(indegree[v] == 0) pQ.add(v);
            }
        }

        if(countVisited != A) return new ArrayList<>();

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(6, 3)));
        B.add(new ArrayList<>(List.of(6, 1)));
        B.add(new ArrayList<>(List.of(5, 1)));
        B.add(new ArrayList<>(List.of(5, 2)));
        B.add(new ArrayList<>(List.of(3, 4)));
        B.add(new ArrayList<>(List.of(4, 2)));

        System.out.println(new TopologicalSort().solve(6, B));
    }

}
