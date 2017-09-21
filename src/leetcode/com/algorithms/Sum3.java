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
 * @author willi
 */
public class Sum3 {

    public static void main(String[] args) {
        int[] a = {1,2,-2,-1};
        List<List<Integer>> sum3 = sum3(a);
        for (List<Integer> l : sum3) {
            System.out.println("");
            for (int ele : l) {
                System.out.print(ele);
            }
        }
    }

    public static List<List<Integer>> sum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        //sort it. Otherwise we will have headache with duplicates sets
        //and it stills O(n²) time complexity
        Arrays.sort(nums);

        for (int i = 0; i < size - 2; i++) {
            int left = i+1, right = size - 1, sum = - nums[i];
            /*
            * i == 0 -> there is no previous element, therefore there is no way
            *      that we have checked the combination with sum 
            * nums[i] != nums[i - 1] -> we cannot generate same combination that
            *       that we have generate before
            *nums[i] < 1 -> for  0 > a,b > x => !∃ x | a+b = -x 
            */
            if ((i == 0 || nums[i] != nums[i - 1])
                    && nums[i] < 1) {
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        // if we found a combination
                        result.add(Arrays.asList(nums[left], nums[right], -sum));
                        //walk left to the right while equals values
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //walk right to the left while equals values
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // walk both boundaries to leave from the same combination
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > sum) {
                        //if the sum is greater than two elements, it walks from
                        //right to the left to decrease the value
                        right--;
                    } else {
                        //if the sum is smaller than two elements, it walks from
                        // left to the right to increase the value
                        left++;
                    }
                }
            }

        }
        return result;
    }

}
