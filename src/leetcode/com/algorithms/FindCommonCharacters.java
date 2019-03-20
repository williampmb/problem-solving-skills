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
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[] cur = new int[26], rpt = new int[26];
        List<String> ans = new ArrayList<>();
        
        for(char c: A[0].toCharArray()){
            cur[c-97]++;
        }
        
        for(int i = 1; i < A.length;i++){
            rpt = new int[26];
            String iWord = A[i];
            for(int pos = 0; pos < iWord.length();pos++){
                char c = iWord.charAt(pos);
                if(cur[c-97]>0){
                    cur[c-97]--;
                    rpt[c-97]++;
                }
            }
            cur = rpt;
        }
        for(int i= 0;i<26;i++){
            char c = (char) (i+97);
            while(cur[i]>0){
                ans.add(c+"");
                cur[i]--;
            }
        }
        return ans;
    }
}
