package advanced.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    List<Integer> ans = new ArrayList<>();
    public int isValidBST(TreeNode A) {
        inorder(A);
        for(int i=0; i<ans.size()-1; i++) {
            if(ans.get(i) > ans.get(i+1)) return 0;
        }
        return 1;
    }
    void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    public boolean isValidBst2(TreeNode A) {
        return isBst(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBst(TreeNode A, int l, int r) {
        if(A == null) return true;
        if(A.val > l && A.val < r) return isBst(A.left, l, A.val);
        else return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(5);
        ValidBST obj = new ValidBST();
        System.out.println(obj.isValidBst2(root));
    }

}
