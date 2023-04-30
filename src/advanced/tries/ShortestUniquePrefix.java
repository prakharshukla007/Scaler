package advanced.tries;

import advanced.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ShortestUniquePrefix {

    public class TrieNode {
        int freq;
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            freq = 0;
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word : A) insert(root, word);
        for(String word : A) {
            ans.add(findPrefix(root, word));
        }
        return ans;
    }

    public String findPrefix(TrieNode root, String word) {
        String ans = "";
        TrieNode cur = root;
        int n = word.length();
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(cur.freq == 1 || cur.isEnd) {
                return ans;
            }
            cur = cur.children[idx];
            ans += ch;
        }
        return ans;
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
        cur.isEnd = true;
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(List.of("trie", "trap", "plate", "place", "cat"));
        System.out.println(new ShortestUniquePrefix().prefix(words));
    }

}
