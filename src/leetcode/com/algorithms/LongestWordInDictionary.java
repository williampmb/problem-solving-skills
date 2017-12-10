/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author willi
 */
public class LongestWordInDictionary {
    public static void main(String[] args){
        LongestWordInDictionary l = new LongestWordInDictionary();
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        String longest = l.longestWord(words);
        System.out.println(longest);
    }

    class TrieNode {

        char val;
        TrieNode[] dic;
        boolean word;

        TrieNode() {
            this.val = ' ';
            dic = new TrieNode[26];
            word = false;
        }
        
        String maxStringDFS(){
            
            StringBuilder max = new StringBuilder();
            for(TrieNode t : dic){
                TrieNode cur = t;
                StringBuilder tmp = new StringBuilder();
                if(cur == null) continue;
                if(cur.word){
                    tmp.append(cur.val);
                    tmp.append(cur.maxStringDFS());
                    if(max.length() < tmp.length()){
                        max = tmp;
                    }
                }
            }
            return max.toString();
        }
    }

    public String longestWord(String[] words) {

        TrieNode root = new TrieNode();
        //Build the dictionary
        for (String w : words) {
            TrieNode cur = root;
            for (int i = 0; i < w.length(); i++) {
                int hash = w.charAt(i) - 'a';
                if (cur.dic[hash] == null) {
                    cur.dic[hash] = new TrieNode();
                    cur.dic[hash].val = w.charAt(i);
                }
                if (i == w.length() - 1) {
                    cur.dic[hash].word = true;
                }
                cur = cur.dic[hash];
            }
        }
        //DSF to look for the longest String
        return root.maxStringDFS();
    }
    
    public String longestWord2(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
