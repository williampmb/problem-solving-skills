/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;

/**
 *
 * @author William Barbosa
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        for(int i= 1; i<n;i++) ans[i]=ans[i-1]*nums[i-1];
        int tmp = nums[n-1];
        for(int i=n-2;i>=0;i--){
            ans[i] *= tmp;
            tmp*=nums[i];
        }
        return ans;
    }
}
