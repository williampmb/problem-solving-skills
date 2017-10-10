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
public class UglyNumber {
    public static void main(String[] args){
        System.out.println(isUgly(2147483647));
    }

    public static boolean isUgly(int num) {
        if (num <= 0 ) {
            return false;
        }
        int[] prime = {2, 3, 5};
        for (int p : prime) {
            while (num % p == 0) {
                num /= p;
            }
            if(num == 1) return true;
        }

        return false;
    }
 
}
