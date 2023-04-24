package advanced.trees;

import java.util.*;

public class BoundaryTraversal {
    ArrayList<Integer> leaves = new ArrayList<>();

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> leftView = new ArrayList<>();
        ArrayList<Integer> rightView = new ArrayList<>();
        inorder(A);
        ArrayList<Integer> ls = new ArrayList<>();
        queue.add(A);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                leftView.add(ls.get(0));
                rightView.add(ls.get(ls.size() - 1));
                ls = new ArrayList<>();
                if (!queue.isEmpty()) queue.add(null);
            } else {
                ls.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        for (int i = 0; i < leaves.size() - 1; i++) {
            if (leftView.contains(leaves.get(i)) || rightView.contains(leaves.get(i))) {
                leaves.remove(i);
                i--;
            }
        }
        rightView.remove(0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int n : leftView) ans.add(n);
        for (int i = 0; i < leaves.size(); i++) ans.add(leaves.get(i));
        Collections.reverse(rightView);
        for (int n : rightView) ans.add(n);
        return ans;
    }

    public void inorder(TreeNode A) {
        if (A == null) return;
        inorder(A.left);
        if (A.left == null && A.right == null) leaves.add(A.val);
        inorder(A.right);
    }

    //Correct solution

    public ArrayList<Integer> solve2(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();
        addLeft(A, arr);
        addLeaf(A, arr);
        addRight(A, arr);
        return arr;
    }

    public boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return false;
    }

    public void addLeft(TreeNode root, ArrayList<Integer> arr) {
        TreeNode current = root;
        while (current != null) {
            if (!isLeaf(current))
                arr.add(current.val);
            if (current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }

    public void addRight(TreeNode root, ArrayList<Integer> arr) {
        TreeNode current = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.val);
            }

            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        // To reverse the right node and as root is taken already in the left node calculation so loop is running till index 1 and we are ignoring index 0
        for (int i = temp.size() - 1; i >= 1; i--) {
            arr.add(temp.get(i));
        }
    }

    public void addLeaf(TreeNode root, ArrayList<Integer> arr) {
        TreeNode current = root;

        if (isLeaf(current)) {
            arr.add(current.val);
            return;
        }

        if (current.left != null) addLeaf(current.left, arr);
        if (current.right != null) addLeaf(current.right, arr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BoundaryTraversal().solve(root));
    }

}
