package linkedLists;

public class LinkedList {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static Node createList(int n) {
        Node head = new Node(1);
        Node temp = head;
        for(int i=2; i<=n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        return head;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        printList(createList(10));
    }

}
