package advanced.contest4;

import advanced.trees.TreeNode;

public class NodesEqualToAverage {

    public class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int count = 0;
    public int solve(TreeNode A) {
        util(A);
        return count;
    }
    public Pair util(TreeNode root) {
        if(root.left == null && root.right == null) {
            Pair p = new Pair(root.val, 1);
            count++;
            return p;
        }

        Pair left = new Pair(0, 0);
        Pair right = new Pair(0, 0);

        if(root.left != null) {
            left = util(root.left);
        }
        if(root.right != null) {
            right = util(root.right);
        }

        int sum = left.x + right.x + root.val;
        int count = left.y + right.y + 1;

        if(sum/count == root.val) this.count++;

        return new Pair(sum, count);
    }

}
