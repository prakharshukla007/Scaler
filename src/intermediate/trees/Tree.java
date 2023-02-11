package trees;

import java.util.ArrayList;
import java.util.Stack;

public class Tree {

    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    Node root;

    public ArrayList<Integer> preorderTraversalRec(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
    public void preorder(Node root, ArrayList<Integer> ls) {
        if(root == null) return;

        ls.add(root.val);
        preorder(root.left, ls);
        preorder(root.right, ls);
    }
    public ArrayList<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            ans.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return ans;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.preorderTraversalRec(tree.root));
        System.out.println(tree.preorderTraversal(tree.root));
    }

}
