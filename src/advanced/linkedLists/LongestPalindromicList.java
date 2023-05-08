package advanced.linkedLists;

public class LongestPalindromicList {

    public int solve(ListNode A) {
        int maxLength = Integer.MIN_VALUE;
        ListNode prev = null;
        ListNode cur = A;
        while(cur != null) {
            ListNode next = cur.next;
            maxLength = Math.max(maxLength, expand(prev, next, true));
            maxLength = Math.max(maxLength, expand(prev, cur, false));
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return maxLength;
    }

    private int expand(ListNode prev, ListNode next, boolean isOdd) {
        ListNode cur1 = prev;
        ListNode cur2 = next;
        int length = 0;
        while(cur1 != null && cur2 != null) {
            if(cur1.val == cur2.val) length++;
            else break;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(isOdd)
            return 2 * length + 1;
        return 2 * length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        System.out.println(new LongestPalindromicList().solve(head));
    }

}
