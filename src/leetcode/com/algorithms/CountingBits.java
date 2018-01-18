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
public class CountingBits {

    public static void main(String[] args) {
        int num = 5;
        int[] bits = countBits2(num);
        for (int i : bits) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    //there is a pattern for every power of 2.
    private static int[] countBits(int num) {
        int[] bits;
        if (num == 0) {
            bits = new int[1];
            return bits;
        }
        if (num == 1) {
            int[] b = {0, 1};
            return b;
        }
        if (num == 2) {
            int[] b = {0, 1, 1};
            return b;
        }

        bits = new int[num + 1];
        bits[1] = 1;
        bits[2] = 1;
        bits[3] = 2;

        int start = 2, end = 3;
        int cur = 4;
        int power = 2;
        while (cur < bits.length) {
            cur = copySubArray(start, end, cur, bits);
            if (end - start >= 0) {
                start = (start + end) / 2;
                start++;
            } else {
                bits[cur] = bits[cur - 1] + 1;
                cur++;
                power *= 2;
                end += power;
            }

        }

        return bits;
    }

    private static int copySubArray(int start, int end, int cur, int[] bits) {
        int pos = start;
        while (cur < bits.length && pos <= end) {
            bits[cur++] = bits[pos++];
        }
        return cur;
    }

    //Author: lixx2100 at leetcode
    public static int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1);
            //f[i] = f[i/2] + (i%2);  same thing above
        }
        return f;
    }
}
