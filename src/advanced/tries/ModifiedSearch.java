package advanced.tries;

import java.util.ArrayList;
import java.util.List;

public class ModifiedSearch {

    public class Node {
        boolean isEnd;
        Node[] children;

        public Node() {
            isEnd = false;
            children = new Node[26];
        }
    }

    public String solve(ArrayList<String> A, ArrayList<String> B) {
        StringBuilder ans = new StringBuilder();
        Node root = new Node();
        for (String value : A) insert(root, value);
        for (String s : B) ans.append(search(s, root, 0, 0) ? 1 : 0);
        return ans.toString();
    }

    public boolean search(String word, Node root, int index, int count) {
        if(count > 1 || index == word.length() && count != 1) return false;
        if (index == word.length() && root.isEnd) return true;
        Node cur = root;
        boolean flag = false;
        char ch = word.charAt(index);
        for(int i=0; i<26; i++) {
            if(cur.children[i] != null && i == ch - 'a') {
                flag = flag | search(word, cur.children[i], index+1, count);
            }
            else if(cur.children[i] != null) {
                flag = flag | search(word, cur.children[i], index+1, count+1);
            }
        }
        return flag;
    }

    public void insert(Node root, String word) {
        int n = word.length();
        Node cur = root;
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of("data", "circle", "cricket"));
        ArrayList<String> B = new ArrayList<>(List.of("date", "circel", "crikket", "data", "circl"));
        System.out.println(new ModifiedSearch().solve(A, B));
    }

}
