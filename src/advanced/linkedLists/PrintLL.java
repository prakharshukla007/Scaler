package advanced.linkedLists;

public class PrintLL {

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static int size(ListNode head) {
        if(head == null) return 0;
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

}
