/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author willi
 */
public class NextGreaterElementI {
    
    public static void main(String[] args){
        NextGreaterElementI n = new NextGreaterElementI();
       // int[] a = {4,1,2};
        int[] a = {2,4};
        int[] b = {};
        
        int[] r = n.nextGreaterElement(a, b);
        for(int i : r ){
            System.out.print(i + " | ");
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> db = new Hashtable<Integer, Integer>();
        int length = nums1.length;
        int length1 = nums2.length;
        for (int i = 0; i < length1; i++) {
            db.put(nums2[i], i);
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            if (db.containsKey(nums1[i])) {
                int index = db.get(nums1[i]);
                for(int j = index ; j < length1 ; j++){
                    if(nums2[j]> nums1[i]){
                        result[i] = nums2[j];
                        break;
                    }
                    result[i] = -1;
                }
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
