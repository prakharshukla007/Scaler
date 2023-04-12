package advanced.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public String solve(String A) {
        int n = A.length();
        String ans = "";

        Map<Character, Integer> hm = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            Character c = A.charAt(i);
            if(!hm.containsKey(c)) queue.add(c);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            while(!queue.isEmpty() && hm.get(queue.peek()) > 1) queue.poll();
            if(queue.isEmpty()) ans += "#";
            else ans += queue.peek();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharacter().solve("abadbc"));
    }

}
