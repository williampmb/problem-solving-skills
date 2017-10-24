/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author willi
 */
public class ReverseBits {

    public static void main(String[] args) {

        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int reversed = 0;
        int mask = 1;
        for (int i = 32; i > 0; i--) {
            if ((n & mask) == 1) {
                reversed |= 1;
            }
            if (i != 1) {
                reversed = reversed << 1;
            }

            n >>>= 1;
        }
        return reversed;
    }

    //Autor: AlexTheGreat at leetcode.com
    // cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits2(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) // convert int into 4 bytes
        {
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3) {
                result <<= 8;
            }
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b); // first look up from cache
        if (value != null) {
            return value;
        }
        value = 0;
        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7) {
                value <<= 1;
            }
        }
        cache.put(b, value);
        return value;
    }
}
