package advanced.contest3;

import advanced.linkedLists.ListNode;
import advanced.linkedLists.PrintLL;

import java.util.ArrayList;
import java.util.List;

public class RotateListKTimes {

    public ListNode solve(ListNode A, int B) {
        int size = 0;
        ListNode temp = A;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        System.out.println(size);

        if(size == 1) return A;

        while(B > size) {
            B = B % size;
        }

        if(B == size) return A;

        int count = B;
        temp = A;
        while(count > 1) {
            count--;
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        ListNode temp2 = newHead;
        while(temp2.next != null) temp2 = temp2.next;
        temp2.next = A;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ArrayList<Integer> ls = new ArrayList<>(List.of(74, 18, 69, 43, 76, 86, 95, 20, 16, 71, 1, 20, 53, 77, 56, 73, 80, 33, 24, 52, 7, 41, 21, 26, 71, 78, 39, 78, 7, 34, 45, 22));
        ListNode head2 = PrintLL.constructLL(ls);

        PrintLL.printLL(new RotateListKTimes().solve(head2, 33));
    }

}
