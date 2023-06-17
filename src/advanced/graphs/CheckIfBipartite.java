package advanced.graphs;

import java.util.ArrayList;
import java.util.List;

public class CheckIfBipartite {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] adjList = new ArrayList[A];
        for(int i=0; i<A; i++) adjList[i] = new ArrayList<>();
        for(ArrayList<Integer> ls : B) {
            adjList[ls.get(0)].add(ls.get(1));
            adjList[ls.get(1)].add(ls.get(0));
        }

        int[] color = new int[A];
        for(int i=0; i<A; i++) color[i] = -1;

        for(int i=0; i<A; i++) {
            if(color[i] == -1) {
                if(!checkDfs(i, 0, adjList, color)) return 0;
            }
        }

        return 1;
    }

    public boolean checkDfs(int start, int c, ArrayList<Integer>[] adjList, int[] color) {
        color[start] = c;
        for(int v : adjList[start]) {
            if(color[v] == color[start]) return false;
            else if(color[v] == -1) {
                if(!checkDfs(v, 1-c, adjList, color)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(7, 8)));
        B.add(new ArrayList<>(List.of(1, 2)));
        B.add(new ArrayList<>(List.of(0, 9)));
        B.add(new ArrayList<>(List.of(1, 3)));
        B.add(new ArrayList<>(List.of(6, 7)));
        B.add(new ArrayList<>(List.of(0, 3)));
        B.add(new ArrayList<>(List.of(2, 5)));
        B.add(new ArrayList<>(List.of(3, 8)));
        B.add(new ArrayList<>(List.of(4, 8)));

        System.out.println(new CheckIfBipartite().solve(10, B));
    }

}
