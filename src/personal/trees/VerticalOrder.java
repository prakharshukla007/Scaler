package personal.trees;

import advanced.trees.TreeNode;

import java.util.*;

public class VerticalOrder {

    public static class Pair<T, V> {
        T x;
        V y;
        public Pair(T x, V y) {
            this.x = x;
            this.y = y;
        }
    }

    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        util(A);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> keySet = hm.keySet();
        for(int key : keySet) {
            max = Math.max(max, key);
            min = Math.min(min, key);
        }

        for(int i=min; i<=max; i++) {
            ans.add(hm.get(i));
        }

        return ans;
    }

    public void util(TreeNode A) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(A, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            if(cur.x.left != null) queue.add(new Pair<>(cur.x.left, cur.y - 1));
            if(cur.x.right != null) queue.add(new Pair<>(cur.x.right, cur.y + 1));
            if(hm.containsKey(cur.y)) {
                hm.get(cur.y).add(cur.x.val);
            } else {
                hm.put(cur.y, new ArrayList<>(List.of(cur.x.val)));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(new VerticalOrder().verticalOrderTraversal(root));
    }

}
