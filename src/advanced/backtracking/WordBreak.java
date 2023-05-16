package advanced.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public int wordBreak(String A, ArrayList<String> B) {
        return wordBreakUtil(A, B) ? 1 : 0;
    }

    public boolean wordBreakUtil(String s, ArrayList<String> result) {
        if (s.equals("")) return true;
        for (int i = 0; i < Math.min(20, s.length()); i++) {
            String str = s.substring(0, i + 1);
            if (result.contains(str) && wordBreakUtil(s.substring(i + 1), result)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "a";
        ArrayList<String> ls = new ArrayList<>(List.of("aaa"));
        System.out.println(new WordBreak().wordBreak(a, ls));
    }

}
