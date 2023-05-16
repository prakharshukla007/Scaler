package advanced.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {

    ArrayList<String> ans;

    public ArrayList<String> letterCombinations(String A) {
        ans = new ArrayList<>();

        Map<String, String> hm = new HashMap<>();
        hm.put("0", "0");
        hm.put("1", "1");
        hm.put("2", "abc");
        hm.put("3", "def");
        hm.put("4", "ghi");
        hm.put("5", "jkl");
        hm.put("6", "mno");
        hm.put("7", "pqrs");
        hm.put("8", "tuv");
        hm.put("9", "wxyz");

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<A.length(); i++) arr.add(hm.get(A.charAt(i) + "")); // This "" converts char to string
        StringBuilder str = new StringBuilder();
        
        util(arr, str, 0);
        
        return ans;
    }

    private void util(ArrayList<String> arr, StringBuilder str, int i) {
        if(str.length() == arr.size()) {
            ans.add(str.toString());
            return;
        }

        String word = arr.get(i);

        for(int j=0; j<word.length(); j++) {
            str.append(word.charAt(j));
            util(arr, str, i+1);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterPhone().letterCombinations("23"));
    }

}
