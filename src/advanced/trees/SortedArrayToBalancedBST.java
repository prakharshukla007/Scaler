package advanced.trees;

public class SortedArrayToBalancedBST {

    public TreeNode sortedArrayToBST(final int[] A) {
        return buildBst(A, 0, A.length-1);
    }

    public TreeNode buildBst(int[] A, int st, int end) {
        if(st > end) return null;
        int mid = (st + end)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildBst(A, st, mid-1);
        root.right = buildBst(A, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 5, 10};
        System.out.println(LevelOrderTraversal.levelOrder2(new SortedArrayToBalancedBST().sortedArrayToBST(A)));
    }

}
