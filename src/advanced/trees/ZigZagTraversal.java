package advanced.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {

    static ArrayList<ArrayList<Integer>> zigZag(TreeNode A) {
        // Your code here
        ArrayList<Integer> subAns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        boolean flip = true;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                if (flip) {
                    flip = false;
                    ans.add(subAns);
                } else {
                    flip = true;
                    Collections.reverse(subAns);
                    ans.add(subAns);
                }
                subAns = new ArrayList<>();
                if (!queue.isEmpty()) queue.add(null);
            } else {
                subAns.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigZag(root));
    }

}
