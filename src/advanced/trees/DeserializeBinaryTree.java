package advanced.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

    public static TreeNode solve(ArrayList<Integer> A) {
        Queue< TreeNode > queue = new LinkedList< >();
        queue.add(new TreeNode(A.get(0)));
        int i = 1;
        TreeNode head = queue.peek();
        while (!queue.isEmpty() && i < A.size()) {
            TreeNode poll = queue.poll();
            if (A.get(i) != -1) {
                poll.left = new TreeNode(A.get(i));
                queue.add(poll.left);
            }
            i++;
            if (A.get(i) != -1) {
                poll.right = new TreeNode(A.get(i));
                queue.add(poll.right);
            }
            i++;
        }
        return head;
    }

}
