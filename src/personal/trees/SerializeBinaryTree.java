package personal.trees;

import advanced.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                if (!queue.isEmpty()) queue.add(null);
            } else {
                ans.add(cur.val);
                if(cur.val == -1) continue;
                if (cur.left != null) queue.add(cur.left);
                else queue.add(new TreeNode(-1));
                if (cur.right != null) queue.add(cur.right);
                else queue.add(new TreeNode(-1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new SerializeBinaryTree().solve(root));
    }

}
