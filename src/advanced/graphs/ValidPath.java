package advanced.graphs;

import java.util.ArrayList;

public class ValidPath {

    int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    boolean[][] visited;

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        visited = new boolean[A+1][B+1];
        dfs(0, 0, A, B, D, E, F);
        return visited[A][B] ? "YES" : "NO";
    }

    private void dfs(int i, int j, int A, int B, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        if(!isValid(i, j, A, B, D, E, F)) return;
        visited[i][j] = true;
        for(int k=0; k<8; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            dfs(ni, nj, A, B, D, E, F);
        }
    }

    private boolean isValid(int i, int j, int A, int B, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        if(i < 0 || j < 0 || i > A || j > B || visited[i][j]) return false;
        for(int k=0; k<E.size(); k++) {
            int dist = ((i - E.get(k)) * (i - E.get(k))) + ((j - F.get(k)) * (j - F.get(k)));
            if(dist <= D * D) return false;
        }
        return true;
    }

}
