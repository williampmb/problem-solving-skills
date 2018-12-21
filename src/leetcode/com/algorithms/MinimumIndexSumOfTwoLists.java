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
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> db = new HashMap<>();
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i< list1.length;i++){
            db.put(list1[i],i);
        }
        
        for(int i = 0 ; i < list2.length;i++){
            if(db.containsKey(list2[i])){
                int index = db.get(list2[i]);
                if(index +i == sum){
                    ans.add(list2[i]);
                }else if(index + i < sum ){
                    sum = index+i;
                    ans = new ArrayList<>();
                    ans.add(list2[i]);
                }
            }
        }
        
        return ans.toArray(new String[0]);
    }
}
