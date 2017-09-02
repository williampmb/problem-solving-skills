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
public class RomanToInteger {
    public static void main(String[] args){
        String roman = "IV";
    }

    public static int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        int sum = 0;
        int size = s.length();
        
        int pos =0;
        int lastValue = Integer.MAX_VALUE;
        int value;
        while(pos < size){
            value = getValor(s.charAt(pos));
            if(lastValue<value){
                sum += -2*lastValue;
                sum += value;
            }else{
                sum+= value;
            }
            lastValue = value;
            pos++;
        }
        return sum;
    }

    public static int getValor(char roman) {
        switch (roman) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }
}
