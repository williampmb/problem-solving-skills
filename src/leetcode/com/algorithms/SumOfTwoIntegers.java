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
public class SumOfTwoIntegers {

    public static void main(String[] args) {
        SumOfTwoIntegers s = new SumOfTwoIntegers();
        int num = s.getSum2(5, -1);
        System.out.println(num);

    }
    
    //Author: zhaolz at leetcode
    // Iterative
    public int getSum3(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    // Iterative
    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    //Recursively
    int getSum2(int a, int b) {
        return b == 0 ? a : getSum2(a ^ b, (a & b) << 1); //be careful about the terminating condition;
    }

    public int getBit(int num, int pos) {
        return num & (1 << pos);
    }

    private int setBit(int num, int pos) {
        return num | (1 << pos);
    }
}
