package advanced.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * DOESN'T WORK
 */
public class MAXandMIN {

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> largeLeft = getLeftLargest(A);
        ArrayList<Integer> largeRight = getRightLargest(A);
        int sum = 0;

        for(int i=0; i<n; i++) {
            int s = i - largeLeft.get(i);
            int e = largeRight.get(i) == -1 ? n-1 : largeRight.get(i) - i;
            sum += (s*e) * A.get(i);
        }

        ArrayList<Integer> smallLeft = getLeftSmallest(A);
        ArrayList<Integer> smallRight = getRightSmallest(A);

        for(int i=0; i<n; i++) {
            int s = i - smallLeft.get(i);
            int e = smallRight.get(i) == -1 ? n-1 : smallRight.get(i) - i;
            sum -= (s*e) * A.get(i);
        }

        return sum;
    }

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

    public ArrayList<Integer> getRightLargest(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) stack.pop();
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

    public ArrayList<Integer> getLeftSmallest(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) stack.pop();
            if(stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }

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
        System.out.println(new MAXandMIN().solve(new ArrayList<>(List.of(2, 5, 3))));
    }

}
