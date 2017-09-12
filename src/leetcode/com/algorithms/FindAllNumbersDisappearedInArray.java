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
 * @author willi
 */
public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args){
        int[] a = {4,3,2,7,8,2,3,1};
        
        List<Integer> findDisappearedNumbers = findDisappearedNumbers(a);
    }
    
    //solution in leetcode.com
    /*
    * Java accepted simple solution
    * The basic idea is that we iterate through the input array and mark 
    * elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In this 
    * way all the numbers that we have seen will be marked as negative. In the 
    * second iteration, if a value is not marked as negative, it implies we have 
    * never seen that index before, so just add it to the return list.
    */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
