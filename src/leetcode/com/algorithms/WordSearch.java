/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "see";

        boolean exist = w.exist(board, word);
        System.out.println(exist);

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        /* Instead of using extra space to know which chars have I used, It is
        * better setting the actual char to a invalid char of letters flipping 
        * its bits. =>  board[i][j] ^= 256  after coming back from the backtrack
        * to set a valid char again, We need just to flip bits again board[i][j] ^= 256
        * I left using extra memory to see this approach in the future :p
        */
        boolean ans = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;

                    ans = backtrack(board, used, word, 1, i + 1, j) || backtrack(board, used, word, 1, i - 1, j)
                            || backtrack(board, used, word, 1, i, j + 1) || backtrack(board, used, word, 1, i, j - 1);
                    used[i][j] = false;
                }
            }
        }
        return ans;
    }

    private boolean backtrack(char[][] board, boolean[][] used, String word, int charAt, int row, int col) {
        if (charAt == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || used[row][col]) {
            return false;
        }
        boolean ans = false;

        if (word.charAt(charAt) == board[row][col]) {
            used[row][col] = true;
            ans = backtrack(board, used, word, charAt + 1, row + 1, col)
                    || backtrack(board, used, word, charAt + 1, row, col + 1)
                    || backtrack(board, used, word, charAt + 1, row - 1, col)
                    || backtrack(board, used, word, charAt + 1, row, col - 1);

            used[row][col] = false;
        }
        return ans;

    }
}
