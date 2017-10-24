/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class NumberOf1Bits {
    public static void main(String[] args){
        NumberOf1Bits n = new NumberOf1Bits();
        int a = n.hammingWeight(2);
        System.out.println(a);
        
    }

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ones++;
            }
            n>>>=1;
        }
        return ones;
    }
}
