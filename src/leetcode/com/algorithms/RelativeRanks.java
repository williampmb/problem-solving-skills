/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author willi
 */
public class RelativeRanks {
    public static void main(String[] args){
        RelativeRanks r = new RelativeRanks();
        int[] nums = {7,1,5,10,2};
        String[] findRelativeRanks = r.findRelativeRanks(nums);
        for(String s: findRelativeRanks){
            System.out.println(s);
        }
    }

    public String[] findRelativeRanks(int[] nums) {

        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });

        String[] rank = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                rank[index[i]] = "Gold Medal";
            } else if (i == 1) {
                rank[index[i]] = "Silver Medal";
            } else if (i == 2) {
                rank[index[i]] = "Bronze Medal";
            } else {
                rank[index[i]] = (i + 1) + "";
            }
        }
        return rank;
    }
}
