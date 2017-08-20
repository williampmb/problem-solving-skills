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
public class TwoSum {
    public static void main(String[] args){
        int[] a = {1};
        int t = 92;
        int[] s = twoSum(a, t);
        if(s != null){
            System.out.println(s[0] + " "+ s[1]);
        }else{
            System.out.println("Not found");
        }
    }
    
    public static int[] twoSum(int[] nums, int target){
        if(nums == null )return null;
        int size = nums.length;
        int[] r = new int[2];
        Map<Integer,Integer> db = new Hashtable<Integer, Integer>();
        for(int i = 0 ; i < size ; i++){
            if(db.containsKey(target-nums[i])){
                r[0] = db.get(target-nums[i]);
                r[1] = i;
                return r;
            }else{
                db.put(nums[i], i);
            }
        }
        return null;
    }
}
