package advanced.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PossibilityOfFinishing {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<Integer>[] adjList = new ArrayList[A+1];
        for(int i=0; i<=A; i++) adjList[i] = new ArrayList<>();
        for(int i=0; i<B.size(); i++) {
            adjList[B.get(i)].add(C.get(i));
        }

        int[] indegree = new int[A+1];
        for(int u=1; u<=A; u++) {
            for(int v : adjList[u]) indegree[v]++;
        }

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i=1; i<=A; i++) {
            if(indegree[i] == 0) pQ.add(i);
        }

        if(pQ.isEmpty()) return 0;

        int countVisited = 0;

        while(!pQ.isEmpty()) {
            int cur = pQ.poll();
            countVisited++;
            for(int v : adjList[cur]) {
                indegree[v]--;
                if(indegree[v] == 0) pQ.add(v);
            }
        }

        if(countVisited != A) return 0;
        return 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>(List.of(1, 2));
        ArrayList<Integer> C = new ArrayList<>(List.of(2, 1));
        System.out.println(new PossibilityOfFinishing().solve(2, B, C));
    }

}
