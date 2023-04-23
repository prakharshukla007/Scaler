package advanced.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

    public ArrayList<Integer> inorderTraversalIterative(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode cur = A;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new InorderTraversal().inorderTraversalIterative(root));
    }

}
