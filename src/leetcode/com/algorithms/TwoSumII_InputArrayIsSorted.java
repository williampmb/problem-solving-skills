/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        
        while(left<right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{++left, ++right};
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{0,0};
    }
}
