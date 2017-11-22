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
public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        int n = 8;
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(b.hasAlternatingBits(n));

        b.hasAlternatingBits(n);
    }

    public boolean hasAlternatingBits(int n) {
        int shifted = n << 1;
        //check if it starts with 1 or 0 to shift and add the correct value.
        if (!((n & 1) == 1)) {
            shifted |= 1;
        }
        //it makes xor as 00011111 number.
        int xor = shifted ^ n;
        // it means that if I add 1 it will be a power of 2
        // so if we make power of 2 & (power of 2) -1 it should be zero
        // otherwise xor is not the number we expected. Therefore it is false.
        return (xor & (xor + 1)) == 0;
    }
    
   /* Author:  StefanPochmann  at leetcode (c++)
    * bool hasAlternatingBits(int n) {
    *    return !((n ^= n/4) & n-1);
    * }
    */
    
}
