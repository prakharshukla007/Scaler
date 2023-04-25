package advanced.linkedLists;

public class ReverseInGroupsOfK {

    public ListNode reverseList(ListNode A, int B) {
        int size = PrintLL.size(A);
        int noOfHeads = size / B;
        A = reverseUtil(A, B);
        PrintLL.printLL(A);
        ListNode temp = A;
        ListNode prev = null;
        while(noOfHeads > 1) {
            noOfHeads--;
            int count = B;
            while(count > 0) {
                prev = temp;
                temp = temp.next;
                count--;
            }
            prev.next = reverseUtil(temp, B);
        }
        return A;
    }

    public ListNode reverseUtil(ListNode head, int groupSize) {
        ListNode temp = head;
        int count = groupSize;
        while(count > 0) {
            temp = temp.next;
            count--;
        }
        ListNode prev = temp;
        ListNode cur = head;
        ListNode next;
        count = groupSize;
        while(count > 0) {
            count--;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        ReverseInGroupsOfK obj = new ReverseInGroupsOfK();
        node1 = obj.reverseList(node1, 2);
        PrintLL.printLL(node1);
    }

}
