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
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args){
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        int[] nums = {2,2,3,4,3,4,1,5,1,5};
        f.findDuplicates(nums);
    }
    

     // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
    
   
}
