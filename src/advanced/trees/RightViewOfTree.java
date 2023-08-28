package advanced.trees;

import java.util.*;

public class RightViewOfTree {

    public ArrayList<Integer> rightView(TreeNode A) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(A);
        TreeNode last = A;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
            if(cur == last) {
                ans.add(cur.val);
                last = queue.peekLast();
            }
        }

        return ans;
    }

    public ArrayList<Integer> rightView2(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        queue.add(A);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                ans.add(level.get(level.size()-1));
                level = new ArrayList<>();
                if(!queue.isEmpty()) queue.add(null);
            } else {
                level.add(cur.val);
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

        System.out.println(new RightViewOfTree().rightView2(root));
    }

}
