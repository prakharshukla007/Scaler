package advanced.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return ans;
    }

    ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> preorderRec(TreeNode A) {
        if(A == null) return ans;
        ans.add(A.val);
        preorderRec(A.left);
        preorderRec(A.right);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new PreOrderTraversal().preorderRec(root));
    }

}
