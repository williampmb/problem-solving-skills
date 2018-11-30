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
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int pos =0,count =0, size = S.length();
        char target = S.charAt(0);
        
        for(int i = 0 ; i < size; i++){
            if(target != S.charAt(i)){
                if(count>2){
                    List<Integer> group = new ArrayList<>();
                    group.add(pos);
                    group.add(i-1);
                    ans.add(group);
                }
                count=1;
                pos=i;
                target = S.charAt(i);
            }else{
                count++;
            }
        }
        
        if(count>2){
            List<Integer> group = new ArrayList<>();
            group.add(pos);
            group.add(size-1);
            ans.add(group);
        }
        return ans;
    }
}
