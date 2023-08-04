package advanced.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        return buildTreeUtil(A, B, 0, n-1, 0, n-1);
    }

    private TreeNode buildTreeUtil(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int sin, int ein, int spost, int epost) {
        if(sin > ein || spost > epost) return null;
        TreeNode root = new TreeNode(postorder.get(epost));
        int rIdx = findRootInInorder(inorder, root.val, sin, ein);

        int lSize = rIdx - sin;

        root.left = buildTreeUtil(inorder, postorder, sin, rIdx-1, spost, spost+lSize-1);
        root.right = buildTreeUtil(inorder, postorder, rIdx+1, ein, spost+lSize, epost-1);

        return root;
    }

    private int findRootInInorder(ArrayList<Integer> inorder, int val, int sin, int ein) {
        for(int i=sin; i<=ein; i++) {
            if(inorder.get(i) == val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(List.of(4, 2, 7, 5, 1, 3, 6));
        ArrayList<Integer> post = new ArrayList<>(List.of(4, 7, 5, 2, 6, 3, 1));

        TreeNode root = new BinaryTreeFromInorderAndPostorder().buildTree(in, post);

        System.out.println(LevelOrderTraversal.levelOrder1(root));
    }

}
