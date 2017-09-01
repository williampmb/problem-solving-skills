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
public class Array1 {
//--------------------------------
public boolean firstLast6(int[] nums) {
  int size = nums.length;
  if(size == 1 && nums[0] == 6) return true;
  if(size == 1 && nums[0] != 6) return false;
  if(nums[0] == 6 || nums[size-1] ==6) return true;
  return false;
}
//---------------------------------

//---------------------------------
}
