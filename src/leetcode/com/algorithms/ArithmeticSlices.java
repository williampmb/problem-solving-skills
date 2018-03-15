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
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int count = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i - 2] - A[i - 1] == A[i - 1] - A[i]) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}
