package linkedLists;

public class LinkedList {

    /**
     * Node class
     */
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

    /**
     * head pointer of LinkedList class
     */
    Node head;
    /**
     * Size of the LinkedList
     */
    int size;

    /**
     * Created a LinkedList of n natural numbers
     * @param n - the natural number upto which you want you LinkedList to be created
     * @return - head of the LinkedList containing natural numbers from 1 to n
     */
    Node createListFrom1ToN(int n) {
        head = new Node(1);
        size = 1;
        Node temp = head;
        for(int i=2; i<=n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
            size++;

        }
        return head;
    }

    /**
     * Inserts a node at the head of the LinkedList
     * @param v - the value of the Node you want to insert at head
     * @return - new head of the LinkedList
     */
    Node insertAtHead(int v) {
        /*
        Node newNode = new Node(v);
        if(head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        return head;
         */
        return insertNode(v, 1);
    }

    /**
     * Inserts a new node at the end of the LinkedList
     * @param v - value of the new node
     * @return - head of the LinkedList after insertion at the tail
     */
    Node insertAtTail(int v) {
        Node newNode = new Node(v);
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = newNode;
        size++;
        return head;
    }

    /**
     *
     * @param v - the value of node
     * @param p - the position it needs to be inserted in, in the LinkedList
     * @return - head of the LinkedList
     */
    Node insertNode(int v, int p) {
        Node newNode = new Node(v);
        Node curr = head;
        if(p == 1) {
            newNode.next = head;
            head = newNode;
        }
        else {
            for (int i = 1; i < p - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        size++;
        return head;
    }

    /**
     * Prints the LinkedList
     * @param head - head of the LinkedList
     */
    void printList(Node head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * Prints the LinkedList in reverse order, recursively
     * @param head - head of the LinkedList
     */
    void printInReverse(Node head) {
        if(head == null)
            return;
        if(head.next == null) {
            System.out.print(head.val + " ");
            return;
        }

        printInReverse(head.next);
        System.out.print(head.val + " ");
    }

    /**
     * Returns the size of the LinkedList
     * @return - size of the LinkedList
     */
    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.printList(ls.createListFrom1ToN(10));
        System.out.println(ls.getSize());
        ls.insertNode(100, 3);
        ls.printList(ls.head);
        ls.insertAtTail(500);
        ls.printList(ls.head);
        ls.insertAtHead(3000);
        ls.printList(ls.head);
        ls.printInReverse(ls.head);
        System.out.println();

        LinkedList ls1 = new LinkedList();
        ls1.head = new Node(17);
        ls1.head.next = new Node(4);
        ls1.head.next.next = new Node(12);
        ls1.head.next.next.next = new Node(10);
        ls1.head.next.next.next.next = new Node(5);
        ls1.printInReverse(ls1.head);
    }

}
