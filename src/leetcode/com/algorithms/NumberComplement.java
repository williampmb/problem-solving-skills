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
public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement n = new NumberComplement();
        System.out.println(n.findComplement(-1));
    }

    public int findComplement(int num) {
        int tmp = num;
        int count = 0;
        while (tmp != 0) {
            tmp >>= 1;
            count++;
        }
        int mask = ~((~0) << count);
        return (~num)&mask;
    }
}
