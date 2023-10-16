package personal.linkedList;

import advanced.linkedLists.ListNode;
import advanced.linkedLists.PrintLL;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseIter(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public ListNode reverseInRange(ListNode head, int l, int r) {
        ListNode prev = null;
        ListNode temp = head;
        int count = l;
        while(count-- > 1) {
            prev = temp;
            temp = temp.next;
        }

        ListNode headToRev = temp;

        ListNode temp2 = head;
        count = r;
        while(count-- > 1) temp2 = temp2.next;

        ListNode tailToRev = temp2;

        prev.next = null;
        ListNode storedNext = tailToRev.next;

        tailToRev.next = null;

        reverse(headToRev);

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        PrintLL.printLL(new ReverseLinkedList().reverseIter(head));
    }

}
