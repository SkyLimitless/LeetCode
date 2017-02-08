package Hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aakash on 1/27/2017.
 */
public class Problem212_WordSearch2 {
    public static void main(String[] args) {
        Problem212_WordSearch2 wordSearch2 = new Problem212_WordSearch2();
        String words[] = {"a", "ab", "bd"};
        char[][] board = {{'c', 'a'}, {'a', 'b'}};
        for (Iterator<String> iterator = wordSearch2.findWords(board, words).iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            System.out.println("next = " + next);
        }
    }
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> result = new ArrayList<>();
        buildTree(words);
        if(board.length == 0) return result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                checkWords(result, board, root, i, j);
            }
        }
        return result;
    }

    private void checkWords(List<String> result, char[][] board, TrieNode curr, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char ch = board[i][j];
        int c = board[i][j] - 'a';
        if(board[i][j] == '#' || curr.next[c] == null) return;
        board[i][j] = '#';
        curr = curr.next[c];
        if(curr.word != null) result.add(curr.word);
        curr.word = null;
        checkWords(result, board, curr, i - 1, j);
        checkWords(result, board, curr, i + 1, j);
        checkWords(result, board, curr, i, j - 1);
        checkWords(result, board, curr, i, j + 1);
        board[i][j] = ch;
    }

    private void buildTree(String[] words) {
        for(String word : words) {
            TrieNode temp = root;
            for(char c : word.toCharArray()) {
                if(temp.next[c - 'a'] == null) {
                    temp.next[c - 'a'] = new TrieNode();
                }
                temp = temp.next[c - 'a'];
            }
            temp.word = word;
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}