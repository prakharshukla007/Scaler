package personal.trees;

import advanced.trees.TreeNode;

public class DeleteNodeInBST {

    public TreeNode solve(TreeNode A, int B) {
        if(A == null) return null;

        if(A.val == B) return deleteNode(A);

        TreeNode parent = null;
        TreeNode cur = A;
        while(cur != null) {
            if(cur.val == B) {
                if(parent.left == cur) {
                    parent.left = deleteNode(cur);
                } else {
                    parent.right = deleteNode(cur);
                }
                break;
            } else if(B > cur.val) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }

        return A;
    }

    public TreeNode deleteNode(TreeNode node) {
        if(node == null) return null;

        if(node.left == null && node.right == null) return null;
        else if(node.left != null && node.right == null) {
            return node.left;
        } else if(node.left == null && node.right != null) {
            return node.right;
        } else {
            TreeNode successorParent = node;
            TreeNode successor = node.left;

            while(successor.right != null) {
                successorParent = successor;
                successor = successor.right;
            }

            if(successorParent != node) {
                successorParent.right = successor.left;
                successor.left = node.left;
            }

            successor.right = node.right;

            return successor;
        }
    }

}
