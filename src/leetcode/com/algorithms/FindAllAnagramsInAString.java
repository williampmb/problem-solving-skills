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
 * @author William Barbosa
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<Integer>();
        int pSize = p.length();
        int[] db = new int[26];
        for(char c : p.toCharArray()){
            db[c-97]++;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i =0 ; i<pSize;i++){
            db[s.charAt(i)-97]--;
        }
        
        boolean anagram = checkAnagram(db);
        if(anagram) ans.add(0);
        
        for(int pos = p.length(); pos<s.length(); pos++){
            char c = s.charAt(pos);
            db[c-97]--;
            char cs = s.charAt(pos-pSize);
            db[cs-97]++;
            if(checkAnagram(db))
                ans.add(pos-pSize+1);
        }
        return ans;
    }

    private boolean checkAnagram(int[] db) {
        for(int i: db){
            if(i !=0) return false;
        }
        return true;
    }
}
