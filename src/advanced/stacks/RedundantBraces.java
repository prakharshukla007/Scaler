package advanced.stacks;

import java.util.Stack;

public class RedundantBraces {

    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);
            if(ch != ')') stack.push(ch);
            else {
                int operatorCount = 0;
                while(!stack.isEmpty() && stack.peek() != '(') {
                    char c = stack.peek();
                    if(c == '+' || c == '-' || c =='*' || c == '/') operatorCount++;
                    stack.pop();
                }
                stack.pop();
                if(operatorCount == 0) return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "(a+b)";
        System.out.println(new RedundantBraces().braces(s));
    }

}
