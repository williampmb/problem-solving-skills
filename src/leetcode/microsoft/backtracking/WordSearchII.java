/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {

        Trie myTrie = buildTrie(words);

        List<String> ans = new ArrayList<>();
        int[][] used = new int[board.length][board[0].length];
        boolean[] found = new boolean[words.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                matchWord(board, i, j, found, used, myTrie);
            }
        }

        for (int i = 0; i < found.length; i++) {
            if (found[i]) {
                ans.add(words[i]);
            }
        }
        return ans;

    }

    private Trie buildTrie(String[] words) {
        Trie myTrie = new Trie();
        Trie cur = myTrie;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (cur.dic[words[i].charAt(j) - 'a'] == null) {
                    cur.dic[words[i].charAt(j) - 'a'] = new Trie();
                }
                cur = cur.dic[words[i].charAt(j) - 'a'];
                if (j == words[i].length() - 1) {
                    cur.isWord = true;
                    cur.pos = i;
                }
            }
            cur = myTrie;
        }

        return myTrie;
    }

    private void matchWord(char[][] board, int i, int j, boolean[] found, int[][] used, Trie myTrie) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char boardChar = board[i][j];

        if (myTrie.dic[boardChar - 'a'] != null && used[i][j] != 1) {
            used[i][j] = 1;
            Trie cur = myTrie.dic[boardChar - 'a'];

            if (cur.isWord) {
                found[cur.pos] = true;
            }
            matchWord(board, i - 1, j, found, used, cur);
            matchWord(board, i + 1, j, found, used, cur);
            matchWord(board, i, j - 1, found, used, cur);
            matchWord(board, i, j + 1, found, used, cur);

            used[i][j] = 0;
        }
    }

    private static class Trie {

        Trie[] dic;
        int pos;
        boolean isWord;

        public Trie() {
            dic = new Trie[26];
            pos = -1;
            isWord = false;
        }

    }
}
