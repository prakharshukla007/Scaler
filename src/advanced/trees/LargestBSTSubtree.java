package advanced.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LargestBSTSubtree {

    public int solve(TreeNode A) {
        if(isValidBst(A)) return countNodes(A);
        else return Math.max(solve(A.left), solve(A.right));
    }

    public boolean isValidBst(TreeNode A) {
        return isBst(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBst(TreeNode A, int l, int r) {
        if(A == null) return true;
        if(A.val > l && A.val < r) return isBst(A.left, l, A.val) && isBst(A.right, A.val, r);
        else return false;
    }

    public int countNodes(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        int count = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                if(!queue.isEmpty()) queue.add(null);
            } else {
                count++;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return count;
    }

}
