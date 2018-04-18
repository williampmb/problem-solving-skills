/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] nums1 = new int[7];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;

        int[] nums2 = {2, 4, 6, 10};
        m.merge(nums1, 3, nums2, 4);
        System.out.println("");
        for(int i :nums1){
            System.out.print(i + " ");
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;

            }
            i--;
        }

        while (n > 0) {
            nums1[i] = nums2[n - 1];
            i--;
            n--;
        }

        while (m > 0) {
            nums1[i] = nums1[m - 1];
            i--;
            m--;
        }
    }
}
