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
public class StringCompression {

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        char[] a = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'c', 'c', 'b', 'b', 'b', 'b'};
        //char[] a = {};
        int num = s.compress(a);
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int size = chars.length;
        int pos = 1;
        int count = 1;
        char letter = chars[0];
        for (int i = 1; i < size; i++) {
            if (letter == chars[i]) {
                count++;
            } else {
                if (count > 1) {
                    int toSwap = pos;
                    while (count != 0) {
                        int alg = count % 10;
                        chars[pos++] = (char) (48 + alg);
                        count /= 10;
                    }
                    swap(chars, toSwap, pos - 1);
                }
                letter = chars[i];
                chars[pos++] = chars[i];
                count = 1;
            }
        }

        if (count > 1) {
            int toSwap = pos;
            while (count != 0) {
                int alg = count % 10;
                chars[pos++] = (char) (48 + alg);
                count /= 10;
            }
            swap(chars, toSwap, pos - 1);
        }
        return pos;
    }

    private void swap(char[] chars, int toSwap, int end) {
        int count = 0;
        while (toSwap < end) {
            char tmp = chars[toSwap + count];
            chars[toSwap + count] = chars[end - count];
            chars[end - count] = tmp;
            count++;
            toSwap += count;
            end -= count;
        }
    }
}
