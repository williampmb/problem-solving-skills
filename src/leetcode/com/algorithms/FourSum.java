/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {2,2,0,1};
        List<List<Integer>> fourSum = fs.fourSum(nums, 4);

        for (List<Integer> l : fourSum) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int len = nums.length;
        Arrays.sort(nums);

        if (len == 0 || nums[len - 1] * 4 < target) {
            return ans;
        }
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] * 4 > target) {
                break;
            } else {
                List<List<Integer>> ansPartial = threeSum(nums, target, nums[i], i + 1, len);
                if (!ansPartial.isEmpty()) {
                    ans.addAll(ansPartial);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> threeSum(int[] nums, int target, int a, int start, int end) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start; i < end - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] * 3 > target - a) {
                break;
            } else {
                List<List<Integer>> sum2Ans = twoSum(nums, target, a, nums[i], i + 1, end);
                if (!sum2Ans.isEmpty()) {
                    ans.addAll(sum2Ans);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int a, int b, int start, int end) {
        int left = start, right = end - 1;
        List<List<Integer>> ansLast = new ArrayList<>();

        while (left < right) {
            if (left > start && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            if (target == a + b + nums[left] + nums[right]) {
                List<Integer> aList = new ArrayList<>();
                aList.add(a);
                aList.add(b);
                aList.add(nums[left]);
                aList.add(nums[right]);
                ansLast.add(aList);
                left++;
                right--;
            } else if (target > a + b + nums[left] + nums[right]) {
                left++;
            } else if (target < a + b + nums[left] + nums[right]) {
                right--;
            }
        }
        return ansLast;
    }
}
