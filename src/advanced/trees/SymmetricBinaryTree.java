package advanced.trees;

import java.util.ArrayList;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        if(A.left == null && A.right == null) return 1;
        return util(A.left, A.right) ? 1 : 0;
    }

    public boolean util(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if((node1 == null && node2 != null) || (node1 != null && node2 == null)) return false;
        if(node1.val != node2.val) return false;
        return util(node1.left, node2.right) && util(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(4);
        node1.right.left = new TreeNode(3);

    }

}
