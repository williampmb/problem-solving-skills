/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author willi
 */
public class IntersectionOfTwoArrays {

    //Time Complexity O(n+m)
    //Space Complexity O(m)
    // Add one of them into a hashset and check if there are elements from nums2
    // in it.
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int size1 = nums1.length;
        int size2 = nums2.length;

        Set<Integer> setOfResult = new HashSet<Integer>();
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < size1; i++) {
            setOfResult.add(nums1[i]);
        }

        for (int i = 0; i < size2; i++) {
            if (setOfResult.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] array = new int[result.size()];
        int pointer = 0;
        for (Integer i : result) {
            array[pointer++] = i;
        }

        return array;
    }

    //Time Complexity O(nLogn + mLogm)
    //Space Complexity O(d) where d is the bigger array size
    //Sort both arrays and check if there has commum while go through them
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int size1 = nums1.length;
        int size2 = nums2.length;
        List<Integer> result = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < size1; i++) {
            while (i != 0 && i < size1 && nums1[i] == nums1[i - 1]) {
                i++;
            }

            while (i < size1 && j < size2 && nums1[i] > nums2[j]) {
                j++;
            }
            if (i < size1 && j < size2 && nums1[i] == nums2[j]) {
                result.add(nums1[i]);
            }
        }
        int s = result.size();
        int[] array = new int[s];

        for (int i = 0; i < s; i++) {
            array[i] = result.get(i);
        }

        return array;
    }
}
