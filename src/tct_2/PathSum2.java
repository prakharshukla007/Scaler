package tct_2;

import advanced.trees.TreeNode;

import java.util.ArrayList;

public class PathSum2 {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> solve(TreeNode A, int B) {
        findPaths(A, B, new ArrayList<>(), 0);
        return ans;
    }
    public void findPaths(TreeNode A, int B, ArrayList<Integer> curAns, int sum) {
        if(A == null) return;
        if(A.left == null && A.right == null) {
            sum += A.val;
            curAns.add(A.val);
            if(sum == B) ans.add(new ArrayList<>(curAns));
            curAns.remove(curAns.size()-1);
            return;
        }

        sum += A.val;
        curAns.add(A.val);
        findPaths(A.left, B, curAns, sum);
        findPaths(A.right, B, curAns, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new PathSum2().solve(root, 3));
    }
}
