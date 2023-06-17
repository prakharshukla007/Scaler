package advanced.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestingPriorityQueue {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o2.val - o1.val;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<ListNode> pQ = new PriorityQueue<>(new ListNodeComparator());
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode temp = head;
        while(temp != null) {
            pQ.add(temp);
            temp = temp.next;
        }

        while(!pQ.isEmpty()) System.out.println(pQ.poll().val);

        ArrayList<Long> ls = new ArrayList<>();
        ls.add((long)2);
    }

}
