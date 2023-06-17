package advanced.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BlackShapes {

    public class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int black(ArrayList<String> A) {
        int row = A.size();
        int col = A.get(0).length();
        Queue<Node> queue = new LinkedList<>();

        int count = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(A.get(i).charAt(j) == 'X') {
                    queue.add(new Node(i, j));
                    bfs(queue, A);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(Queue<Node> queue, ArrayList<String> A) {
        int row = A.size();
        int col = A.get(0).length();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int i = cur.x;
            int j = cur.y;

            if(i >= 0 && j >= 0 && i < row && j < col && A.get(i).charAt(j) == 'X') {
                StringBuilder sb = new StringBuilder(A.get(i));
                sb.setCharAt(j, 'Y');
                A.set(i, sb.toString());

                for(int k=0; k<8; k++) {
                    int newI = i + dx[k];
                    int newJ = j + dy[k];


                    queue.add(new Node(newI, newJ));
                }
            }
        }
    }

}
