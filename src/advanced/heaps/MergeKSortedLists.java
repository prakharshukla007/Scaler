package advanced.heaps;

import advanced.linkedLists.ListNode;
import advanced.linkedLists.PrintLL;

import java.util.ArrayList;
import java.util.List;

/**
 BUGGY
*/
public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ArrayList<ListNode> heap = new ArrayList<>();
        ListNode head;
        for(ListNode node : a) {
            createHeap(heap, node);
        }

        head = getMin(heap);
        ListNode cur = head;
        if(cur.next != null) {
            heap.add(0, cur.next);
            heapify(heap);
        }
        while(!heap.isEmpty()) {
            cur.next = getMin(heap);
            if(cur.next.next != null) {
                heap.add(0, cur.next.next);
                heapify(heap);
            }
            cur = cur.next;
        }

        return head;
    }

    public ListNode getMin(ArrayList<ListNode> heap) {
        if(heap.size() == 1) return heap.remove(0);
        ListNode ans = heap.remove(0);
        heap.add(0, heap.remove(heap.size()-1));
        heapify(heap);
        return ans;
    }

    public void heapify(ArrayList<ListNode> heap) {
        int n = heap.size();
        int idx = 0;
        boolean flag = true;
        while(idx < n) {
            int LC = 2 * idx + 1;
            int RC = 2 * idx + 2;
            int minC = -1;
            if(LC >= n) flag = false;
            else {
                if(RC >= n) {
                    if(heap.get(LC).val < heap.get(idx).val) minC = LC;
                    else flag = false;
                }
                else if(heap.get(LC).val > heap.get(idx).val && heap.get(RC).val > heap.get(idx).val) flag = false;
                else {
                    if(heap.get(LC).val < heap.get(RC).val) minC = LC;
                    else minC = RC;
                }
            }
            if(!flag) break;
            swap(heap, idx, minC);
            idx = minC;
        }
    }

    public void createHeap(ArrayList<ListNode> heap, ListNode node) {
        heap.add(node);
        int i = heap.size()-1;
        while((i - 1)/2 >= 0 && heap.get((i-1)/2).val > node.val) {
            swap(heap, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    public void swap(ArrayList<ListNode> heap, int idx1, int idx2) {
        ListNode temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }

    public static void main(String[] args) {
        ListNode ls1 = new ListNode(1);
        ls1.next = new ListNode(9);
        ls1.next.next = new ListNode(15);

        ListNode ls2 = new ListNode(2);
        ls2.next = new ListNode(8);
        ls2.next.next = new ListNode(16);

        ListNode ls3 = new ListNode(3);
        ls3.next = new ListNode(7);
        ls3.next.next = new ListNode(17);

        ArrayList<ListNode> list = new ArrayList<>(List.of(ls1, ls2, ls3));
        ListNode head = new MergeKSortedLists().mergeKLists(list);
        PrintLL.printLL(head);
    }

}
