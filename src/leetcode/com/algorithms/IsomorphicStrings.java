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
public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings i = new IsomorphicStrings();
        //System.out.println(i.isIsomorphic2("foo", "bar"));
        System.out.println(i.isIsomorphic2("ab", "ca"));
        //System.out.println(i.isIsomorphic2("egg", "add"));
        //System.out.println(i.isIsomorphic2("ab", "aa"));
        //System.out.println(i.isIsomorphic2("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        int sSize = s.length();
        Map<Character, Character> db = new Hashtable<Character, Character>();

        if (sSize != t.length()) {
            return false;
        }
        for (int i = 0; i < sSize; i++) {
            char firstChar = s.charAt(i);
            char secondChar = t.charAt(i);

            if (db.containsValue(secondChar)) {
                if (!db.containsKey(firstChar)) {
                    return false;
                }
                char mappped = db.get(firstChar);
                if (mappped != secondChar) {
                    return false;
                }
            } else if (db.containsKey(firstChar)) {
                return false;
            } else {
                db.put(firstChar, secondChar);
            }

        }
        return true;
    }

    //Author: grandyang at leetcode
    public boolean isIsomorphic2(String s, String t) {
        int m1[] = new int[256];
        int m2[] = new int[256];

        for (int i = 0; i < s.length(); ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
