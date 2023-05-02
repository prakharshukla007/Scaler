package advanced.linkedLists;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers2(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int sum;
        int carry = 0;
        while (A != null || B != null) {
            if (A == null)
                sum = B.val + carry;
            else if (B == null)
                sum = A.val + carry;
            else sum = A.val + B.val + carry;

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = newNode;
            temp = newNode;

            if (A != null) A = A.next;
            if (B != null) B = B.next;
        }
        if (carry != 0) temp.next = new ListNode(carry);
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode temp = A;
        while (temp != null) {
            stack1.push(temp.val);
            temp = temp.next;
        }
        temp = B;
        while (temp != null) {
            stack2.push(temp.val);
            temp = temp.next;
        }

        String num1 = "";
        while (!stack1.isEmpty()) {
            num1 += stack1.pop().toString();
        }
        String num2 = "";
        while (!stack2.isEmpty()) {
            num2 += stack2.pop().toString();
        }

        Integer ansSum = Integer.valueOf(num1) + Integer.valueOf(num2);
        ListNode root = new ListNode(ansSum % 10);
        ListNode temp2 = root;
        ansSum = ansSum / 10;
        while (ansSum > 0) {
            temp2.next = new ListNode(ansSum % 10);
            ansSum = ansSum / 10;
            temp2 = temp2.next;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(2);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(3);

        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(4);

        ListNode ansRoot = new AddTwoNumbers().addTwoNumbers2(root1, root2);
        PrintLL.printLL(ansRoot);
    }

}
