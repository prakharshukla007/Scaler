package advanced.linkedLists;

public class FlattenLinkedList {

    class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode flatten(ListNode root) {
        if(root == null) return null;
        if(root.right == null) return root;
        ListNode cur = root;
        while(cur != null) {
            ListNode nextRight = cur.right;
            ListNode nextHead = cur.right.right;
            cur.right = null;
            merge(cur, nextRight);
            cur = nextHead;
        }
        return root;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode head;
        if(head1.val < head2.val) {
            head = head1;
            head1 = head1.down;
        }
        else {
            head = head2;
            head2 = head2.down;
        }

        ListNode cur = head;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                cur.down = head1;
                head1 = head1.down;
            }
            else {
                cur.down = head2;
                head2 = head2.down;
            }
            cur = cur.down;
        }

        if(head1 != null) cur.down = head1;
        if(head2 != null) cur.down = head2;

        return head;
    }

}
