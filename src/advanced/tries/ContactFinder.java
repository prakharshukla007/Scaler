package advanced.tries;

import java.util.ArrayList;
import java.util.List;

public class ContactFinder {

    public class TrieNode {
        int freq;
        TrieNode[] children;
        public TrieNode() {
            freq = 0;
            children = new TrieNode[26];
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(int i=0; i<n; i++) {
            if(A.get(i) == 0) insert(root, B.get(i));
            else ans.add(findFreq(root, B.get(i)));
        }
        return ans;
    }

    public Integer findFreq(TrieNode root, String s) {
        int n = s.length();
        TrieNode cur = root;
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if(cur.children[idx] == null) return 0;
            cur = cur.children[idx];
        }
        return cur.freq;
    }

    public void insert(TrieNode root, String word) {
        TrieNode cur = root;
        int n = word.length();
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            cur.freq++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> op = new ArrayList<>(List.of(0, 0, 1, 1, 1));
        ArrayList<String> words = new ArrayList<>(List.of("hack", "hacker", "hac", "hak", "cat"));
        System.out.println(new ContactFinder().solve(op, words));
    }

}
