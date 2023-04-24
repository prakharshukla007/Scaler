package advanced.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        int len = A.length();
        for (int i = 0; i < len; i++) {
            char ch = A.charAt(i);
            if (!map.containsKey(ch)) queue.add(ch);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) queue.poll();
            if (queue.isEmpty()) {
                ans.append("#");
            } else {
                ans.append(queue.peek());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharacter().solve("abadbc"));
    }

}
