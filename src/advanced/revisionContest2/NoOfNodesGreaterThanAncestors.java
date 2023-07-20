package advanced.revisionContest2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NoOfNodesGreaterThanAncestors {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int solve(TreeNode A) {
        PriorityQueue<TreeNode> pQ = new PriorityQueue<>((a, b) -> b.val - a.val);
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> curLevel = new ArrayList<>();
        queue.add(A);
        queue.add(null);
        int count = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                pQ.addAll(curLevel);
                curLevel = new ArrayList<>();
                if(!queue.isEmpty()) queue.add(null);
            } else {
                curLevel.add(cur);
                if(pQ.isEmpty()) count++;
                else if(!pQ.isEmpty() && cur.val > pQ.peek().val) count++;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        System.out.println(new NoOfNodesGreaterThanAncestors().solve(root));
    }

}
