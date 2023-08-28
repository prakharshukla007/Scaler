package advanced.trees;

import java.util.ArrayList;
import java.util.List;

public class CreateBST {

    public void insert(TreeNode root, int x) {
        if(root == null) return;
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(x < cur.val) {
                parent = cur;
                cur = cur.left;
            }
            else {
                parent = cur;
                cur = cur.right;
            }
        }
        if(x < parent.val) parent.left = new TreeNode(x);
        else parent.right = new TreeNode(x);
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(5, 20, 2, 7, 15, 23, 6, 9, 21));
        TreeNode root = new TreeNode(10);
        CreateBST obj = new CreateBST();
        for(int n : ls) obj.insert(root, n);

        System.out.println(LevelOrderTraversal.levelOrder1(root));
    }

}
