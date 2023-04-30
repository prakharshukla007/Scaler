package advanced.tries;

import java.util.ArrayList;
import java.util.List;

public class SpellingChecker {

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        TrieNode root = new TrieNode();
        for(String word : A) { insert(root, word); }
        ArrayList<Integer> ans = new ArrayList<>();
        for(String word : B) {
            if(search(root, word)) ans.add(1);
            else ans.add(0);
        }
        return ans;
    }

    public boolean search(TrieNode root, String word) {
        TrieNode cur = root;
        int n = word.length();
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return cur.isEnd;
    }

    public void insert(TrieNode root, String word) {
        TrieNode cur = root;
        int n = word.length();
        int idx = 0;
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            idx = ch - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of("a", "b"));
        ArrayList<String> B = new ArrayList<>(List.of("a", "b"));
        ArrayList<Integer> ans = new SpellingChecker().solve(A, B);
        System.out.println(ans);
    }

}
