package advanced.linkedLists;

public class SwapInPairs {

    public ListNode swapPairs(ListNode A) {
        ListNode head = A.next;
        ListNode cur = A;
        ListNode prev = null;
        while(cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            if(prev != null) prev.next = cur.next;
            cur.next = temp;
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = new SwapInPairs().swapPairs(head);
        PrintLL.printLL(head);
    }

}
