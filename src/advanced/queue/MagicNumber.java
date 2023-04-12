package advanced.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MagicNumber {

    public String solve(int A) {
        if(A == 1) return "11";
        if(A == 2) return "22";

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        boolean flag = true;

        while(A > 0) {
            StringBuilder s = new StringBuilder(queue.peek());
            if(flag) {
                s.append("1");
            }
            else {
                s.append("2");
                queue.poll();
            }
            queue.add(s.toString());
            flag = !flag;
            A--;
            if(A - 2 == 0) {
                return s.toString() + s.reverse();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new MagicNumber().solve(9));
    }

}
