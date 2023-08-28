package personal.trees;

import advanced.trees.LevelOrderTraversal;
import advanced.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeserializeBinaryTree {

    public TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < A.size()) {
            TreeNode cur = queue.poll();
            if(A.get(i) != -1) {
                cur.left = new TreeNode(A.get(i));
                queue.add(cur.left);
            }
            i++;
            if(A.get(i) != -1) {
                cur.right = new TreeNode(A.get(i));
                queue.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
        System.out.println(LevelOrderTraversal.levelOrder1(new DeserializeBinaryTree().solve(ls)));
    }

}
