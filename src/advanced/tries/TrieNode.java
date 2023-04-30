package advanced.tries;

public class TrieNode {

    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }

}
