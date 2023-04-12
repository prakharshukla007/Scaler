package advanced.hashing;

import java.util.HashSet;

public class ColorfulNumber {

    public int colorful(int A) {
        String s = ((Integer)A).toString();

        HashSet<Integer> hs = new HashSet<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                int mul = 1;
                String subS = s.substring(i, j);
                for(Character c : subS.toCharArray()) mul *= Integer.valueOf(c.toString());
                if(hs.contains(mul)) return 0;
                hs.add(mul);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(2634));
    }

}
