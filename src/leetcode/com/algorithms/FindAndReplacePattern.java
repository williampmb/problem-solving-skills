/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author William Barbosa
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        Map<Character, Character> map;
        List<String> ans = new ArrayList<>();
        int n = pattern.length();

        for (String s : words) {
            map = new HashMap<>();
            if (s.length() == n) {
                boolean mapped = true;
                for (int i = 0; i < n; i++) {
                    char letterS = s.charAt(i);
                    char letterP = pattern.charAt(i);
                    if (!map.containsKey(letterP) && !map.containsKey(letterS)) {
                        map.put(letterP, letterS);
                        map.put(letterS, letterP);
                    } else if (map.containsKey(letterP) && !map.containsKey(letterS) || (!map.containsKey(letterP) && map.containsKey(letterS)) || (map.get(letterP) != letterS || letterP != map.get(letterS))) {
                        mapped = false;
                        break;
                    } 

                }
                if (mapped) {
                    ans.add(s);
                }
            }
        }
        return ans;

    }
}
