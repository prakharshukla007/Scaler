package advanced.linkedLists;

import java.util.ArrayList;

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

    public static ListNode constructLL(ArrayList<Integer> ls) {
        ListNode head = new ListNode(ls.get(0));
        ListNode temp = head;
        for(int i=1; i<ls.size(); i++) {
            temp.next = new ListNode(ls.get(i));
            temp = temp.next;
        }
        return head;
    }

}
