package advanced.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesLevelOrder {

    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null) return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                if(!queue.isEmpty()) queue.add(null);
            }
            else {
                count++;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new CountNodesLevelOrder().countNodes(root));
    }

}
