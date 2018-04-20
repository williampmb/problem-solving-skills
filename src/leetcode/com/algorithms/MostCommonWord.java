/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import utils.DicNode;

/**
 *
 * @author William Barbosa
 */
public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord m = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit it bob bob.";
        String[] banned = {"hit", "ball", "it"};
        String mostCommonWord = m.mostCommonWord(paragraph, banned);
        System.out.println(mostCommonWord);
    }

    
    //A way of doing it without using extra libraries.
    public String mostCommonWord(String paragraph, String[] banned) {
        DicNode dic = new DicNode(0);
        DicNode.buildBannedDic(banned, dic);

        int mostCommun = 0;
        StringBuilder word = new StringBuilder(); 

        StringBuilder curWord = new StringBuilder(); 

        DicNode cur = dic;
        boolean isWord = false;
        for (int i = 0; i < paragraph.length(); i++) {
            char letter = paragraph.charAt(i);

            if (((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'))) {
                isWord = true;
                curWord.append(letter);
                int index = letter > 'Z' ? (letter - 'a') : (letter - 'A');
                if (cur.root[index] == null) {
                    cur.root[index] = new DicNode(0);
                }
                cur = cur.root[index];
            } else if (isWord && cur.value != -1) {
                cur.value++;
                isWord = false;
                if (mostCommun < cur.value) {
                    mostCommun = cur.value;
                    word = curWord;
                }
                curWord = new StringBuilder();
                cur = dic;
            } else {
                curWord = new StringBuilder();
                cur = dic;
            }
        }
        return word.toString();
    }
}
