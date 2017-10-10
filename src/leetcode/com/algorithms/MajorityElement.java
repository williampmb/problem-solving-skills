/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author willi
 */
public class MajorityElement {

    public static void main(String[] args) {
        //int[] a = {1,5,2,2,2,2,32,2,4,6,58,141,6};
        int[] a = {1, 6, 6, 6, 6, 8, 7, 9, 5, 6, 4, 6, 7, 2, 4};
        majorityElement(a);
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> db = new Hashtable<Integer, Integer>();
        for (int i : nums) {
            if (db.containsKey(i)) {
                Integer count = db.get(i);
                db.put(i, ++count);
            } else {
                db.put(i, 1);
            }
        }

        Set<Integer> keySet = db.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        int max = 0;
        int maxNumb = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer get = db.get(next);
            if (get > max) {
                maxNumb = next;
                max = get;
            }
        }
        System.out.println(maxNumb);
        return maxNumb;
    }

    //jojocat1010 leetcode solution - Best solution
    // if the majority celing of n/2, it always end the majority with the at 
    // least one. 
    public int majorityElement2(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    //cute but expensive
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len / 2];
    }
}
