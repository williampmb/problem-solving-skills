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
public class IntegerBreak {

    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int ans = 1;
        while (n != 0) {
            if (n > 4 || n == 3) {
                ans *= 3;
                n -= 3;
            } else {
                ans *= 2;
                n -= 2;
            }
        }
        return ans;
    }
}
