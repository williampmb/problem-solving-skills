/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willi
 */
public class KeyboardRow {

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow  k = new KeyboardRow();
        String[] findWords = k.findWords(words);
        for(String s: findWords){
            System.out.println(s);
        }
    }

    public String[] findWords(String[] words) {
        int[] keyboard = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> output = new ArrayList<>();
        int row = 0;
        for (String word : words) {
            String wordLowerCase = word.toLowerCase();
            if (word.length() != 0) {
                char c = wordLowerCase.charAt(0);
                int rowWord = keyboard[c - 'a'];
                boolean onlyAtRow = true;
                for (int i = 1; i < wordLowerCase.length(); i++) {
                    if (keyboard[wordLowerCase.charAt(i) - 'a'] != rowWord) {
                        onlyAtRow = false;
                        break;
                    }
                }
                if(onlyAtRow){
                    output.add(word);
                }
            }
        }
        String[] out = new String[output.size()];
        return output.toArray(out);
    }
}
