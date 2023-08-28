package advanced.trees;

import java.util.*;

public class VerticalOrder {

    public class Pair<T, V> {
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
        Set<Integer> keySet = hm.keySet();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : keySet) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        for (int i = min; i <= max; i++) {
            ArrayList<Integer> ls = null;
            if (keySet.contains(i)) {
                ls = hm.get(i);
            }
            ans.add(ls);
        }
        return ans;
    }

    public ArrayList<Integer> topView(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        util(A);
        Set<Integer> keySet = hm.keySet();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : keySet) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        for (int i = min; i <= max; i++) {
            ArrayList<Integer> ls = null;
            if (keySet.contains(i)) {
                ls = hm.get(i);
            }
            assert ls != null;
            ans.add(ls.get(0));
        }
        return ans;
    }

    public void util(TreeNode r) {
        if (r == null) return;
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(r, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            if (cur.x.left != null) queue.add(new Pair<>(cur.x.left, cur.y - 1));
            if (cur.x.right != null) queue.add(new Pair<>(cur.x.right, cur.y + 1));
            if (hm.containsKey(cur.y))
                hm.get(cur.y).add(cur.x.val);
            else {
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(cur.x.val);
                hm.put(cur.y, ls);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new DeserializeBinaryTree().solve(new ArrayList<>(List.of(1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1)));
        VerticalOrder obj = new VerticalOrder();
        System.out.println(obj.verticalOrderTraversal(root));
    }

}
