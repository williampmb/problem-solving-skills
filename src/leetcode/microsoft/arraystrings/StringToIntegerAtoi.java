/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

/**
 *
 * @author William Barbosa
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        StringToIntegerAtoi s = new StringToIntegerAtoi();
        String str = "42";

        System.out.println(s.myAtoi(str));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        int numb = 0, signal = 1, pos = 0, length = str.length();
        if (length == 0) {
            return 0;
        }

        while (pos < length && str.charAt(pos) == ' ') {
            pos++;
        }
        if (pos < length && str.charAt(pos) == '-') {
            signal = -1;
            pos++;
        } else if (pos < length && str.charAt(pos) == '+') {
            pos++;
        }

        while (pos < length && validNumb(str.charAt(pos))) {
            int tmp = numb;
            numb *= 10;
            numb += (str.charAt(pos) - '0');
            if (tmp != numb / 10) {
                if (signal == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            pos++;
        }
        return signal * numb;
    }

    private boolean validNumb(char dig) {
        if (dig < '0' || dig > '9') {
            return false;
        }
        return true;
    }
}
