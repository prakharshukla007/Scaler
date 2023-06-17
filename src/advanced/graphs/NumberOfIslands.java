package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        Queue<Node> queue = new LinkedList<>();

        int count = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(A.get(i).get(j) == 1) {
                    queue.add(new Node(i, j));
                    bfs(queue, A);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(Queue<Node> queue, ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int i = cur.i;
            int j = cur.j;

            if(i >= 0 && i < row && j >=0 && j < col && A.get(i).get(j) == 1) {
                A.get(i).set(j, 2);

                for(int k=0; k<8; k++) {
                    int newI = i + dx[k];
                    int newJ = j + dy[k];

                    queue.add(new Node(newI, newJ));
                }
            }
        }
    }

}
