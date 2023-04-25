package advanced.linkedLists;

public class ReverseInRange {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int start = B;
        ListNode temp = A;
        ListNode prev = null;
        while(start > 1) {
            prev = temp;
            temp = temp.next;
            start--;
        }

        ListNode temp2 = A;
        int endNext = C;
        while(endNext > 0) {
            temp2 = temp2.next;
            endNext--;
        }

        ListNode prev2 = prev;
        ListNode cur = temp;
        ListNode next;
        int count = C-B;
        while(cur != null && count > 0) {
            count--;
            next = cur.next;
            cur.next = temp2;
            prev2 = cur;
            temp2 = prev2;
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
        node1 = new ReverseInRange().reverseBetween(node1, 1, 6);
        PrintLL.printLL(node1);
    }

}
