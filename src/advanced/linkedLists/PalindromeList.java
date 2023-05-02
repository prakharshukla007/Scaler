package advanced.linkedLists;

public class PalindromeList {

    public int lPalin(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);
        ListNode cur1 = A;
        ListNode cur2 = head2;

        while(cur1 != null && cur2 != null) {
            if(cur1.val != cur2.val) return 0;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return 1;
    }

    public ListNode reverse(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        System.out.println(new PalindromeList().lPalin(head));
    }

}
