package advanced.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class RemoveInvalidParantheses {

    ArrayList<ArrayList<Character>> arrangements;

    public ArrayList<String> solve(String A) {
        arrangements = new ArrayList<>();
        util(0, 0, 0, A, new ArrayList<>());

        Collections.sort(arrangements, new ArrComparator());

        int len = arrangements.get(0).size();
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<arrangements.size(); i++) {
            if(arrangements.get(i).size() < len) break;
            StringBuilder sb = new StringBuilder();
            for(char c : arrangements.get(i)) {
                sb.append(c);
            }
            hs.add(sb.toString());
        }

        return new ArrayList<>(hs);
    }

    public void util(int idx, int open, int close, String A, ArrayList<Character> arrangement) {
        if(idx == A.length()) {
            if(open == close) {
                arrangements.add(new ArrayList<>(arrangement));
            }
            return;
        }

        char ch = A.charAt(idx);
        if(ch == '(') {
            arrangement.add(ch);
            util(idx+1, open+1, close, A, arrangement);
            arrangement.remove(arrangement.size()-1);
        }
        else if(ch == ')' && open > close) {
            arrangement.add(ch);
            util(idx+1, open, close+1, A, arrangement);
            arrangement.remove(arrangement.size()-1);
        }
        else if(ch >= 'a' && ch <= 'z') {
            arrangement.add(ch);
            util(idx+1, open, close, A, arrangement);
            arrangement.remove(arrangement.size()-1);
        }

        util(idx+1, open, close, A, arrangement);
    }

    public class ArrComparator implements Comparator<ArrayList<Character>> {
        @Override
        public int compare(ArrayList<Character> o1, ArrayList<Character> o2) {
            return o2.size() - o1.size();
        }
    }

}
