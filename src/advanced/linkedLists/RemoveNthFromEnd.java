package advanced.linkedLists;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A == null) return null;
        int size = 0;
        ListNode temp = A;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        if(B >= size) {
            A = A.next;
            return A;
        }
        else {
            int count = 0;
            ListNode temp2 = A;
            ListNode prev = null;
            while(count != size - B) {
                prev = temp2;
                temp2 = temp2.next;
                count++;
            }
            prev.next = temp2.next;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        RemoveNthFromEnd obj = new RemoveNthFromEnd();
        ListNode newHead = obj.removeNthFromEnd(node1, 1);
        PrintLL.printLL(newHead);
    }

}
