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
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String input = "aabbccddee";

        //pwwkewabcde
        int s = lengthOfLongestSubstring(input);
        System.out.println(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int pstart = 0, pend = 0, size = s.length(), max = 1;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return 1;
        }

        Map<Character, Integer> db = new Hashtable<>();

        char[] target = s.toCharArray();
        while (pend != size) {
            if (pend == pstart) {
                if (pend != size) {
                    db.put(target[pend], 1);
                }
                pend++;
                continue;
            } else if (getNumbDb(target[pend], db) > 0) {
                if (target[pend] != target[pstart] && max < pend - pstart) {
                    max = pend - pstart;
                }
                char repeated = target[pend];
                while (pstart != pend) {
                    int numbChar = getNumbDb(target[pstart], db);
                    numbChar--;
                    db.put(target[pstart], numbChar);
                    char lookingfor = target[pstart];
                    pstart++;
                    if (repeated == lookingfor) {
                        break;
                    }
                }
            } else {
                db.put(target[pend], 1);
                pend++;

                if (pend == size && max < pend - pstart) {
                    if (target[pend - 1] != target[pstart]) {
                        max = pend - pstart;
                    }

                }
            }
        }
        return max;

    }

    private static int getNumbDb(char c, Map<Character, Integer> db) {
        if (db.get(c) == null) {
            return 0;
        }
        return db.get(c);
    }
}
