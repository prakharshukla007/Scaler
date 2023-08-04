package advanced.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class FirstSmallestToRight {

    public ArrayList<Integer> getRightSmallest(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) stack.pop();
            if(stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            stack.push(i);
        }

        ArrayList<Integer> ans2 = new ArrayList<>();
        for(int i=n-1; i>=0; i--) ans2.add(ans.get(i));
        return ans2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>(List.of(2, 4, 10, 1, 9, 6));
        System.out.println(new FirstSmallestToRight().getRightSmallest(ls));
    }

}
