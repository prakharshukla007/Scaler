package advanced.linkedLists;

public class PartitionList {

    public ListNode partition(ListNode A, int B) {
        ListNode lesserHead = null;
        ListNode tempLess = null;
        ListNode greaterHead = null;
        ListNode tempGreater = null;
        while(A != null) {
            if(A.val >= B) {
                if(greaterHead == null) {
                    greaterHead = new ListNode(A.val);
                    tempGreater = greaterHead;
                }
                else {
                    tempGreater.next = new ListNode(A.val);
                    tempGreater = tempGreater.next;
                }
            }
            else {
                if(lesserHead == null) {
                    lesserHead = new ListNode(A.val);
                    tempLess = lesserHead;
                }
                else {
                    tempLess.next = new ListNode(A.val);
                    tempLess = tempLess.next;
                }
            }
            A = A.next;
        }

        if(lesserHead == null) {
            return greaterHead;
        }

        ListNode temp = lesserHead;
        while(temp.next != null) temp = temp.next;
        temp.next = greaterHead;

        return lesserHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(2);
        PrintLL.printLL(new PartitionList().partition(head, 2));
    }

}
