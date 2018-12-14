/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author William Barbosa
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> db = new HashSet<>();
        if(nums == null || k <=0) return false;
        for(int i = 0 ; i < nums.length; i++){
            if(i>k) db.remove(nums[i-k-1]);
            if(db.contains(nums[i])) return true;
            db.add(nums[i]);
        }
        return false;
    }
}
