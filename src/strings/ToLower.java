package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class ToLower {

    public static ArrayList<Character> to_lower(ArrayList<Character> A) {
        int n = A.size();
        for(int i=0; i<n; i++) {
            if(A.get(i) >= 'a' && A.get(i) <= 'z')
                A.set(i, (char)((int)A.get(i) ^ (1<<5)));
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Character> ls = new ArrayList<>(Arrays.asList('S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0'));
        System.out.println(to_lower(ls));
    }

}
