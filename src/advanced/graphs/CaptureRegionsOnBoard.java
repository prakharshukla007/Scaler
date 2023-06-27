package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CaptureRegionsOnBoard {

    public class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();

        for(int i=0; i<m; i++) {
            if(a.get(0).get(i) == 'O') {
                bfs(new Node(0, i), a);
            }
            if(a.get(n-1).get(i) == 'O') {
                bfs(new Node(n-1, i), a);
            }
        }

        for(int i=0; i<n; i++) {
            if(a.get(i).get(0) == 'O') {
                bfs(new Node(i, 0), a);
            }
            if(a.get(i).get(m-1) == 'O') {
                bfs(new Node(i, m-1), a);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a.get(i).get(j) == 'O') a.get(i).set(j, 'X');
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a.get(i).get(j) == 'V') a.get(i).set(j, 'O');
            }
        }
    }

    public void bfs(Node start, ArrayList<ArrayList<Character>> a) {
        Queue<Node> queue = new LinkedList<>();
        int row = a.size();
        int col = a.get(0).size();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        queue.add(start);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int i = cur.i;
            int j = cur.j;

            if(i >= 0 && i < row && j >= 0 && j < col && a.get(i).get(j) == 'O') {
                a.get(i).set(j, 'V');

                for(int k=0; k<4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    queue.add(new Node(ni, nj));
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.add(new ArrayList<>(List.of('X', 'X', 'X', 'X')));
        a.add(new ArrayList<>(List.of('X', 'O', 'O', 'X')));
        a.add(new ArrayList<>(List.of('X', 'X', 'O', 'X')));
        a.add(new ArrayList<>(List.of('X', 'O', 'X', 'X')));

        new CaptureRegionsOnBoard().solve(a);
        System.out.println(a);
    }

}
