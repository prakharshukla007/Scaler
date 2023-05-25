package advanced.linkedLists;

public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int sizeA = 0;
        int sizeB = 0;

        ListNode temp = A;
        while(temp != null) {
            sizeA++;
            temp = temp.next;
        }
        temp = B;
        while(temp != null) {
            sizeB++;
            temp = temp.next;
        }

        int initShift = sizeA - sizeB;
        ListNode tempA = A;
        ListNode tempB = B;
        if(initShift > 0) {
            while(initShift > 0) {
                initShift--;
                tempA = tempA.next;
            }
        } else if(initShift < 0) {
            int abs = initShift * (-1);
            while(abs > 0) {
                abs--;
                tempB = tempB.next;
            }
        }

        while(tempA != null && tempB != null) {
            if(tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(6);

        A.next = new ListNode(2);
        ListNode node1 = new ListNode(3);
        A.next.next = node1;
        B.next = node1;

        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        PrintLL.printLL(new IntersectionOfLinkedList().getIntersectionNode(A, B));
        System.out.println();

        ListNode A1 = new ListNode(1);
        A1.next = new ListNode(2);
        A1.next.next = new ListNode(3);

        ListNode B1 = new ListNode(4);
        B1.next = new ListNode(5);

        System.out.println(PrintLL.size(new IntersectionOfLinkedList().getIntersectionNode(A1, B1)));
    }

}
