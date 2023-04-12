package advanced.hashing;

import java.util.HashSet;
import java.util.List;

public class IsomorphicStrings {

    public int solve(String A, String B) {
        int nA = A.length();
        int nB = B.length();
        if(nA != nB) return 0;

        HashSet<Integer> setA = new HashSet<>();
        for(int i=1; i<nA; i++) {
            if(A.charAt(i) != A.charAt(i-1)) setA.add(i);
        }

        HashSet<Integer> setB = new HashSet<>();
        for(int i=1; i<nB; i++) {
            if(B.charAt(i) != B.charAt(i-1)) setB.add(i);
        }

        if(setA.equals(setB)) return 1;
        return 0;
    }

    public static void main(String[] args) {
        HashSet<Integer> hs1 = new HashSet<>();
        hs1.add(1);
        hs1.add(2);
        hs1.add(3);
        HashSet<Integer> hs2 = new HashSet<>(List.of(1, 2, 3));
        System.out.println(hs1.equals(hs2));
        System.out.println('a' != 'b');

        System.out.println(new IsomorphicStrings().solve("abc", "xyx"));
    }

}
