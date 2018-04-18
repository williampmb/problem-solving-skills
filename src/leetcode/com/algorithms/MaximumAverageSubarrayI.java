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
public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double avg = 0, maxAvg = 0;

        for (int i = 0; i < k; i++) {
            avg += nums[i];
        }

        maxAvg = avg;
        for (int i = k; i < nums.length; i++) {
            avg -= nums[i - k];
            avg += nums[i];
            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        double factor = k;
        return maxAvg / factor;
    }
}
