/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author willi
 */
public class WordPattern {

    public static void main(String[] args) {
        WordPattern w = new WordPattern();
        String pattern = "jquery";
        String str = "jquery";
        System.out.println(w.wordPattern(pattern, str));
    }

    /*
    * Versy similar with IsomorphicStrings. We need to map every char from pattern
    * to a string and check if we have seen this pattern before or string has been
    * added with that map. O(n) time and space complexity where is the size of the
    * pattern.
    */
    public boolean wordPattern(String pattern, String str) {
        
        Map<Character, String> db = new Hashtable<Character, String>();
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);

            if (db.containsValue(words[i]) && !db.containsKey(a)) {
                return false;
            }
            if (db.containsKey(a)) {

                String get = db.get(a);
                if (!get.equals(words[i])) {
                    return false;
                }
            } else {
                db.put(a, words[i]);
            }
        }
        return true;
    }
}
