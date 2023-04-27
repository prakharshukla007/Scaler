package advanced.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextPointerBinary {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        public TreeLinkNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeLinkNode cur = queue.poll();
            if(cur == null) {
                if(!queue.isEmpty()) queue.add(null);
            }
            else {
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                cur.next = queue.peek();
            }
        }
    }

    public void connect2(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeLinkNode cur = queue.poll();
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
            cur.next = queue.peek();
        }
    }

    public void point(ArrayList<TreeLinkNode> ls) {
        for(int i=0; i<ls.size(); i++) {
            if(i == ls.size()-1) {
                ls.get(i).next = null;
            }
            else {
                ls.get(i).next = ls.get(i+1);
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(3);
        root.left = new TreeLinkNode(9);
        root.right = new TreeLinkNode(20);
        root.right.left = new TreeLinkNode(15);
        root.right.right = new TreeLinkNode(7);
        new NextPointerBinary().connect(root);
        TreeLinkNode temp = root.left;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
