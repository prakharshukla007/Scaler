package advanced.linkedLists;

import java.util.ArrayList;

public class MiddleElementFromStack {

    public class DoublyLinkedList {
        int val;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        public DoublyLinkedList(int x) { val = x; }
    }

    DoublyLinkedList head;
    DoublyLinkedList mid;
    int size;

    public int[] solve(int[][] A) {
        ArrayList<Integer> ls = new ArrayList<>();
        size = 0;
        for (int[] op : A) {
            if (op[0] == 1) push(op[1]);
            else if (op[0] == 2) ls.add(pop());
            else if (op[0] == 3) ls.add(getMiddle());
            else deleteMid();
        }

        int[] ans = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) ans[i] = ls.get(i);
        return ans;
    }

    private void deleteMid() {
        if (mid == null) return;
        if (size == 1) {
            head = null;
            mid = null;
            size--;
            return;
        }
        if (size == 2) {
            head = head.next;
            mid = head;
            size--;
            return;
        }
        mid.prev.next = mid.next;
        mid.next.prev = mid.prev;
        if (size % 2 == 0) {
            mid = mid.next;
        } else {
            mid = mid.prev;
        }
        size--;
    }

    private int getMiddle() {
        if (mid == null) return -1;
        return mid.val;
    }

    private int pop() {
        if (head == null) return -1;
        if (size == 1) {
            int temp = head.val;
            head = null;
            mid = null;
            size--;
            return temp;
        }
        if (size % 2 == 0) {
            mid = mid.next;
            int temp = head.val;
            head = head.next;
            size--;
            return temp;
        }
        int temp = head.val;
        head = head.next;
        size--;
        return temp;
    }

    private void push(int i) {
        DoublyLinkedList newNode = new DoublyLinkedList(i);
        if (head == null) {
            head = newNode;
            mid = head;
            size = 1;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            if (size % 2 == 0) mid = mid.prev;
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[10][2];
        A[0] = new int[]{2, 0};
        A[1] = new int[]{4, 0};
        A[2] = new int[]{3, 0};
        A[3] = new int[]{1, 170};
        A[4] = new int[]{1, 479};
        A[5] = new int[]{3, 0};
        A[6] = new int[]{3, 0};
        A[7] = new int[]{1, 706};
        A[8] = new int[]{2, 0};
        A[9] = new int[]{2, 0};

        int[] ans = new MiddleElementFromStack().solve(A);
        for (int n : ans) System.out.print(n + " ");
    }

}
