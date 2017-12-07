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
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0,p2=0;
        int s1 = nums1.length, s2=nums2.length;
        
        List<Integer> tmp = new ArrayList<>();
        while(p1<s1 && p2 < s2){
            if(nums1[p1]==nums2[p2]){
                tmp.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1]>nums2[p2]){
                p2++;
            }else{
                p1++;
            }
        }
        int[] res = new int[tmp.size()];
        for(int i = 0 ; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        
        return res;
    }
}
