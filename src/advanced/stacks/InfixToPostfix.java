package advanced.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

    public String solve(String A) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('(', -1);

        StringBuilder ans = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                ans.append(ch);
                continue;
            }

            if(ch == '(') {
                stack.push(ch);
                continue;
            }

            if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') ans.append(stack.pop());
                stack.pop();
                continue;
            }

            if(stack.isEmpty()) stack.push(ch);
            else {
                if(precedence.get(ch) > precedence.get(stack.peek())) stack.push(ch);
                else {
                    while(!stack.isEmpty() && precedence.get(ch) <= precedence.get(stack.peek())) {
                        char c = stack.pop();
                        ans.append(c);
                    }
                    stack.push(ch);
                }
            }
        }

        while(!stack.isEmpty()) ans.append(stack.pop());

        return ans.toString();
    }

    public String solve2(String A) {
        // Create a StringBuilder to store the postfix expression
        StringBuilder postfix = new StringBuilder();
        // Initialize a stack to hold operators
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            // If c is a letter (operand), append it to the postfix expression
            if (Character.isLetter(c)) {
                postfix.append(c);
            }
            // If c is '(', push it onto the operator stack
            else if (c == '(') {
                operatorStack.push(c);
            }
            // If c is ')', pop operators from the stack until '(' is encountered
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                // After '(' is encountered, remove it from the stack
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }
            // If c is an operator, pop operators from the stack with higher or equal precedence
            // and append them to the postfix expression, then push c onto the stack
            else {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }
        // Append any remaining operators from the stack to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }
        return postfix.toString();
    }

    private int getPrecedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new InfixToPostfix().solve("x^y/(a*z)+b"));
    }

}
