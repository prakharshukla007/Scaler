package advanced.linkedLists;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode cur = A;
        while(cur != null && cur.next != null) {
            if(cur.next.val == cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        obj.deleteDuplicates(node1);
        PrintLL.printLL(node1);
    }

}
