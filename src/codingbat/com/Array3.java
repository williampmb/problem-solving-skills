/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingbat.com;

/**
 *
 * @author willi
 */
public class Array3 {
public boolean canBalance(int[] nums) {
  if(nums == null || nums.length == 1) return false;
  
  int left = 0, right =0;
  right = nums[nums.length-1];
  for(int i = 0 ; i < nums.length-1 ; i++){
    left += nums[i];
  }
  if(left == right) return true;
  
  for(int i = nums.length -2; i >0 ; i--){
    left -= nums[i];
    right +=nums[i];
    if(left == right) return true;
  }
  
  return false;
}

}
