package intermediate.strings;

import java.util.Arrays;

public class ToggleCase {

    public static String solve(String A) {
        char[] arr = A.toCharArray();
        int n = arr.length;
        for(int i=0; i<n; i++)
            arr[i] = (char)((int)arr[i] ^ (1<<5));
        return String.valueOf(arr);
//        String ans = "";
//        for(char c : arr)
//            ans += c;
//        return ans;
    }

    public static void main(String[] args) {
        String name = "PrAkhar";
        System.out.println(solve(name));
    }

}
