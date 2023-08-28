package advanced.linkedLists;

public class ReverseInRange {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int start = B;
        ListNode tempStart = A;
        ListNode prev = null;
        while(start > 1) {
            prev = tempStart;
            tempStart = tempStart.next;
            start--;
        }

        ListNode tempLast = A;
        int endNext = C;
        while(endNext > 0) {
            tempLast = tempLast.next;
            endNext--;
        }

        ListNode prev2 = prev;
        ListNode cur = tempStart;
        ListNode next;
        int count = C-B;
        while(cur != null && count > 0) {
            count--;
            next = cur.next;
            cur.next = tempLast;
            prev2 = cur;
            tempLast = prev2;
            cur = next;
        }
        if(prev != null) {
            cur.next = prev2;
            prev.next = cur;
            return A;
        } else {
            cur.next = prev2;
            return cur;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        node1 = new ReverseInRange().reverseBetween(node1, 2, 5);
        PrintLL.printLL(node1);
    }

}
