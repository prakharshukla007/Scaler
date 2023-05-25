package advanced.linkedLists;

import java.util.ArrayList;

public class MiddleElementFromStack {

    public class DoublyLinkedList {
        int val;
        DoublyLinkedList next;
        DoublyLinkedList prev;
        public DoublyLinkedList(int x) {
            val = x;
        }
    }

    DoublyLinkedList head;
    DoublyLinkedList mid;
    boolean flag = false;
    int size;

    public int[] solve(int[][] A) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int[] op : A) {
            if (op[0] == 1) push(op[1]);
            else if (op[0] == 2) ls.add(pop());
            else if (op[0] == 3) ls.add(getMiddle());
            else deleteMid();
        }

        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++) ans[i] = ls.get(i);
        return ans;
    }

    private void deleteMid() {
        DoublyLinkedList temp;
        if(size % 2 == 0) temp = mid.prev;
        else temp = mid.next;
        mid.prev.next = mid.next;
        mid = temp;
        size--;
    }

    private int getMiddle() {
        return mid.val;
    }

    private int pop() {
        if(head == null) return -1;
        DoublyLinkedList ans = head;
        head = head.next;
        size--;
        return ans.val;
    }

    private void push(int i) {
        if(head == null) {
            flag = true;
            head = new DoublyLinkedList(i);
            mid = head;
            size = 1;
        }
        else {
            DoublyLinkedList newNode = new DoublyLinkedList(i);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            if(flag) {
                if(mid == null) mid = newNode;
                else mid = mid.next;
                flag = false;
            }
            else flag = true;
            size++;
        }
    }

}
