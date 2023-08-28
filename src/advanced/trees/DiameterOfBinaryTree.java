package advanced.trees;

public class DiameterOfBinaryTree {

    int ans = 0;
    public int solve(TreeNode A) {
        height(A);
        return ans - 1;
    }

    public int height(TreeNode A) {
        if(A == null) return 0;
        int l = height(A.left);
        int r = height(A.right);
        ans = Math.max(ans, l+r+1);
        return Math.max(l, r) + 1;
    }

}
