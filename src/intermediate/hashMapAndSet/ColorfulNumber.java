package intermediate.hashMapAndSet;

import java.util.HashSet;

public class ColorfulNumber {

    public static int colorful(int A) {
        HashSet<Long> set = new HashSet<>();
        int n = String.valueOf(A).length();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                String subStr = String.valueOf(A).substring(i, j);
                long prod = 1;
                for(int k=0; k<subStr.length(); k++) {
                    prod *= (long)Integer.valueOf(((Character)subStr.charAt(k)).toString());
                }
                if(set.contains(prod)) return 0;
                set.add(prod);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(colorful(3245));
    }

}
