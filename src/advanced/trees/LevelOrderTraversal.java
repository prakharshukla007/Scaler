package advanced.trees;

import java.util.*;

public class LevelOrderTraversal {

    public static ArrayList<ArrayList<Integer>> levelOrder1(TreeNode A) {
        // Your code here
        ArrayList<Integer> subAns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                ans.add(subAns);
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

    public static ArrayList<ArrayList<Integer>> levelOrder2(TreeNode A) {
        // Your code here
        ArrayList<Integer> subAns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        TreeNode last = A;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            subAns.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            if (cur == last) {
                ans.add(subAns);
                subAns = new ArrayList<>();
                last = queue.peekLast();
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
        System.out.println(levelOrder1(root));
    }

}
