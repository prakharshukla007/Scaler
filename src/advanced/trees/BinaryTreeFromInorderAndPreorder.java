package advanced.trees;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPreorder {

//    A = [1, 6, 2, 3] pre
//    B = [6, 1, 3, 2] in

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        TreeNode root = buildTreeUtil(A, B, 0, n-1, 0, n-1);
        return root;
    }

    public TreeNode buildTreeUtil(ArrayList<Integer> inorder, ArrayList<Integer> preorder, int sin, int ein, int spre, int epre) {
        if(sin > ein || spre > epre) return null;
        TreeNode root = new TreeNode(preorder.get(spre));
        int rIdx = findRootInInorder(inorder, preorder.get(spre), sin, ein);

        int lSize = rIdx - sin;

        root.left = buildTreeUtil(inorder, preorder, sin, rIdx-1, spre+1, spre+lSize);
        root.right = buildTreeUtil(inorder, preorder, rIdx+1, ein, spre+lSize+1, epre);

        return root;
    }

    public int findRootInInorder(ArrayList<Integer> in, int val, int sin, int ein) {
        for(int i=sin; i<=ein; i++) {
            if(in.get(i) == val) return i;
        }
        return -1;
    }

}
