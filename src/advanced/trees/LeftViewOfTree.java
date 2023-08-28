package advanced.trees;

import java.util.*;

public class LeftViewOfTree {

    public ArrayList<Integer> leftView(TreeNode A) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(A);
        TreeNode last = A;
        boolean firstInLevel = true;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(firstInLevel) {
                ans.add(cur.val);
                firstInLevel = false;
            }
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
            if(cur == last) {
                firstInLevel = true;
                last = queue.peekLast();
            }
        }
        return ans;
    }

    public ArrayList<Integer> leftView2(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(A);
        queue.add(null);
        boolean firstInLevel = true;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(firstInLevel) {
                ans.add(cur.val);
                firstInLevel = false;
            }
            if(cur == null) {
                firstInLevel = true;
                if(!queue.isEmpty()) queue.add(null);
            } else {
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(new LeftViewOfTree().leftView2(root));
    }

}
