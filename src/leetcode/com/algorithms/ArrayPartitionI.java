/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author willi
 */
public class ArrayPartitionI {
    public static void main(String[] args){
        System.out.println(500*10000);
    }
    
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        for(int i = 0; i < nums.length; i+=2){
            sum+=nums[i];
        }
        return sum;
    }
}
