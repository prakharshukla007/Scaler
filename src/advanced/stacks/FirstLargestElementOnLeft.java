package advanced.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FirstLargestElementOnLeft {

    public ArrayList<Integer> getLeftLargest(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) stack.pop();
            if(stack.isEmpty()) ans.add(-1);
            else ans.add(stack.peek());
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(2, 4, 10, 1, 9, 6));
        System.out.println(new FirstLargestElementOnLeft().getLeftLargest(ls));
    }

}
