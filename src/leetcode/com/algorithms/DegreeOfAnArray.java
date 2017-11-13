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
public class DegreeOfAnArray {

    public static void main(String[] args) {
        DegreeOfAnArray d = new DegreeOfAnArray();
       int[] a = {1, 2, 2, 3, 1, 4, 2};
//         int[] a = {1, 2, 2, 3, 1};
        int b = d.findShortestSubArray(a);
        System.out.println(b);
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> db = new Hashtable<>();
        int size = nums.length;
        int degree = 0;
        int smallestSubarray = 50001;
        for (int i = 0; i < size; i++) {
            int[] data;
            if (db.containsKey(nums[i])) {
                data = db.get(nums[i]);
            } else {
                data = new int[3];
                data[1] = i;
            }
            data[2] = i;
            data[0] += 1;

            db.put(nums[i], data);
            if (data[0] > degree) {
                degree = data[0];
                smallestSubarray = data[2] - data[1] + 1;
            }else if (degree == data[0]) {
                smallestSubarray = data[2] - data[1] + 1 < smallestSubarray ? data[2] - data[1] + 1 : smallestSubarray;
            }
        }

        return smallestSubarray;
    }
}
