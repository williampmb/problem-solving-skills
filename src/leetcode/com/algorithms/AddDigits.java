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
public class AddDigits {

    public int addDigits(int num) {
        int tmp = 0;
        while (num > 10) {
            tmp += num % 10;
            num /= 10;
        }
        tmp += num;
        if (tmp > 9) {
            tmp = addDigits(tmp);
        }
        return tmp;
    }

    //Author: zhiqing_xiao
    //The problem, widely known as digit root problem, has a congruence formula:
    //https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
    // O(1) runtime 
    public int addDigits2(int num) {
        return 1 + (num - 1) % 9;
    }
}
