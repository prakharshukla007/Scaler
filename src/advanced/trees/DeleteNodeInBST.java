package advanced.trees;

import java.util.Stack;

public class DeleteNodeInBST {

    public TreeNode solve2(TreeNode A, int B) {
        if(A == null) return null;

        if(A.val == B) return deleteNode2(A);

        TreeNode parent = null;
        TreeNode temp = A;

        while(temp != null) {
            if(temp.val == B) {
                if(parent.left == temp) {
                    parent.left = deleteNode2(temp);
                } else {
                    parent.right = deleteNode2(temp);
                }
                break;
            } else if(temp.val < B) {
                parent = temp;
                temp = temp.right;
            } else {
                parent = temp;
                temp = temp.left;
            }
        }

        return A;
    }

    public TreeNode deleteNode2(TreeNode node) {
        if(node == null) return null;

        //no children
        if(node.left == null && node.right == null) return null;
        //one child
        else if(node.left != null && node.right == null) {
            return node.left;
        } else if(node.left == null && node.right != null) {
            return node.right;
        }
        //two children
        else {
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

    public static class Pair<T, V> {
        T x;
        V y;
        public Pair(T x, V y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean isPresent = false;
    TreeNode root;

    public TreeNode solve(TreeNode A, int B) {
        root = A;
        Pair<TreeNode, TreeNode> pair = isPresent(A, B, null);
        if(!isPresent) return null;
        return deleteNode(pair);
    }

    public TreeNode deleteNode(Pair<TreeNode, TreeNode> pair) {
        if(pair.x.left == null && pair.x.right == null) {
            if(pair.y.left.val == pair.x.val) pair.y.left = null;
            else pair.y.right = null;
        }
        else if(pair.x.left == null || pair.x.right == null) {
            if(pair.y == null) {
                if(pair.x.left != null) root = pair.x.left;
                else root = pair.x.right;
                return root;
            }

            boolean leftToParent = false;
            if(pair.y.left.val == pair.x.val) leftToParent = true;
            boolean leftOfCur = false;
            if(pair.x.left != null) leftOfCur = true;

            if(leftToParent) {
                if(leftOfCur) pair.y.left = pair.x.left;
                else pair.y.left = pair.x.right;
            }
            else {
                if(leftOfCur) pair.y.right = pair.x.left;
                else pair.y.right = pair.x.right;
            }
        }
        else {
            Pair<TreeNode, TreeNode> toReplaceWith = findLargestFromLeftSubtree(pair);
            deleteNode(toReplaceWith);
            if(pair.y == null) {
                toReplaceWith.x.left = pair.x.left;
                toReplaceWith.x.right = pair.x.right;
                root = toReplaceWith.x;
            }
            else if(pair.y.left.val == pair.x.val) {
                pair.y.left = toReplaceWith.x;
                toReplaceWith.x.left = pair.x.left;
                toReplaceWith.x.right = pair.x.right;
            }
            else {
                pair.y.right = toReplaceWith.x;
                toReplaceWith.x.left = pair.x.left;
                toReplaceWith.x.right = pair.x.right;
            }
        }
        return root;
    }

    Pair<TreeNode, TreeNode> findLargestFromLeftSubtree(Pair<TreeNode, TreeNode> pair) {
        TreeNode temp = pair.x.left;
        TreeNode tempParent = pair.x;
        while(temp.right != null) {
            tempParent = temp;
            temp = temp.right;
        }
        return new Pair<>(temp, tempParent);
    }

    public Pair<TreeNode, TreeNode> isPresent(TreeNode A, int B, TreeNode parent) {
        Stack<Pair<TreeNode, TreeNode>> stack = new Stack<>();
        TreeNode cur = A;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(new Pair<>(cur, parent));
                parent = cur;
                cur = cur.left;
            }
            Pair<TreeNode, TreeNode> curPair = stack.pop();
            cur = curPair.x;
            if(curPair.x.val == B) {
                isPresent = true;
                return new Pair<>(curPair.x, curPair.y);
            }
            parent = cur;
            cur = cur.right;
        }
        return null;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        DeleteNodeInBST obj = new DeleteNodeInBST();
//        root = obj.solve(root, 3);
//        System.out.println(LevelOrderTraversal.levelOrder1(root));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2 = obj.solve2(root2, 3);
        System.out.println(LevelOrderTraversal.levelOrder1(root2));

//        TreeNode root3 = new TreeNode(6);
//        root3.left =
    }

}
