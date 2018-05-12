/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

/**
 *
 * @author William Barbosa
 */
public class ReverseWordsInAStringII {

    public void reverseWords(char[] str) {
        if (str == null) {
            return;
        }

        int left = 0, right = str.length - 1;

        swapChar(str, left, right);

        left = 0;
        right = str.length - 1;
        while (left <= right) {
            int word = left;
            while (word <= right && str[word] != ' ') {
                word++;
            }
            int endWord = word;

            swapChar(str, left, word - 1);
            left = endWord+1;
        }

    }

    public void swapChar(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }

}
