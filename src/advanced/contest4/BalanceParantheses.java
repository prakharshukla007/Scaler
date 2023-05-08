package advanced.contest4;

import java.util.Stack;

public class BalanceParantheses {

    public int solve(String A) {
        if(A.length() % 2 != 0) return -1;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : A.toCharArray()) {
            if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else stack.push(c);
        }

        String s = "";
        while(!stack.isEmpty()) {
            s += stack.pop();
        }
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) stack.push(c);
            else if(c == '[' && stack.peek() == '[') {
                count++;
                stack.pop();
            }
            else if(c == ']' && stack.peek() == ']') {
                count++;
                stack.pop();
            }
            else if(c == ']' && stack.peek() == '[') {
                count += 2;
                stack.pop();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BalanceParantheses().solve("[[][][]]]]"));
    }

}
