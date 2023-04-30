package advanced.linkedLists;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null) return B;
        if(B == null) return A;
        ListNode head;
        if(A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        ListNode cur = head;
        while(A != null && B != null) {
            if(A.val < B.val) {
                cur.next = A;
                A = A.next;
            } else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }

        if(A != null) cur.next = A;
        if(B != null) cur.next = B;

        return head;
    }

}
