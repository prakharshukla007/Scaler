package advanced.linkedLists;

import java.util.HashSet;

public class RemoveLoopFromLL {

    public ListNode solve(ListNode A) {
        ListNode prev = null;
        ListNode temp = A;
        HashSet<ListNode> hs = new HashSet<>();
        while(temp != null) {
            if(hs.contains(temp)) break;
            hs.add(temp);
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return A;
    }

}
