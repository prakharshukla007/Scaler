package advanced.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = A;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                ans.add(cur.val);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new PostOrderTraversal().postorderTraversal(root));
    }

}
