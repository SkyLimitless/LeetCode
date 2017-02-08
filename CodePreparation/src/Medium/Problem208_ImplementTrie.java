package Medium;

/**
 * Created by Aakash on 1/27/2017.
 */
public class Problem208_ImplementTrie {
    /** Initialize your data structure here. */

}

class TrieNode {
    char val;
    boolean isWord;
    TrieNode next[] = new TrieNode[26];
    public TrieNode(char c) {
        val = c;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ws.next[ch - 'a'] == null) {
                ws.next[ch - 'a'] = new TrieNode(ch);
            }
            ws = ws.next[ch - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ws.next[ch - 'a'] == null) return false;
            ws = ws.next[ch - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(ws.next[ch - 'a'] == null) return false;
            ws = ws.next[ch - 'a'];
        }
        return true;
    }
}