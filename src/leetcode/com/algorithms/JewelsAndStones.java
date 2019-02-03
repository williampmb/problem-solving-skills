/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author William Barbosa
 */
public class JewelsAndStones {

    public static void main(String[] args) {

    }

    public int numJewelsInStones3(String J, String S) {

        Set<Character> jew = new HashSet<>();
        List<Character> stones = new ArrayList<>();
        for (char c : J.toCharArray()) {
            jew.add(c);
        }
        for(char c: S.toCharArray()){
            if(jew.contains(c)){
                stones.add(c);
            }
        }
        return stones.size();
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        int lowerChar = 0, upperChar = 0, countJews = 0;

        for (int i = 0; i < J.length(); i++) {
            char charAt = J.charAt(i);
            if (charAt < 91) {
                upperChar |= (1 << (charAt - 'A'));
            } else {
                lowerChar |= (1 << (charAt - 'a'));
            }
        }

        for (char c : S.toCharArray()) {
            if (c < 91) {
                if ((upperChar & (1 << (c - 'A'))) > 0) {
                    countJews++;
                }
            } else {
                if ((lowerChar & (1 << (c - 'a'))) > 0) {
                    countJews++;
                }
            }
        }
        return countJews;
    }

    //author: @lee215
    // However, extra library and O(n) space complexity. We can solve this
    // with bitmanipulation in 2 integers as used above
    public int numJewelsInStones2(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j : J.toCharArray()) {
            setJ.add(j);
        }
        for (char s : S.toCharArray()) {
            if (setJ.contains(s)) {
                res++;
            }
        }
        return res;
    }

}
