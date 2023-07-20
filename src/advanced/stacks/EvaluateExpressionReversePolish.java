package advanced.stacks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpressionReversePolish {

    Set<String> operators = new HashSet<>(List.of("+", "-", "/", "*"));

    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        for(String s : A) {
            if(operators.contains(s)) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                if(s.equals("+")) stack.push(n1 + n2);
                else if(s.equals("-")) stack.push(n1 - n2);
                else if(s.equals("*")) stack.push(n1 * n2);
                else stack.push(n1 / n2);
            } else stack.push(Integer.valueOf(s));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] A = new String[] {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateExpressionReversePolish().evalRPN(A));
    }

}
