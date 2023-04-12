package advanced.stringPatternMatching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoringSubstring {

    public int solve(String A) {
        List<Character> odd = new ArrayList<>();
        List<Character> even = new ArrayList<>();

        for(char c : A.toCharArray()) {
            if(c%2 == 0) even.add(c);
            else odd.add(c);
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());

        return (Math.abs(odd.get(odd.size() - 1) - even.get(0)) != 1) ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new BoringSubstring().solve("wwuvuw"));
    }

}
