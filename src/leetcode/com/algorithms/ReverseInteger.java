/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Stack;

/**
 *
 * @author willi
 */
public class ReverseInteger {

    public static void main(String[] args) {
        //1534236469
        //32768
        System.out.println(Integer.MAX_VALUE);
        int a = -2147483412;
        System.out.println(Integer.MAX_VALUE / a);

        System.out.println(a);
        int reverse = reverseInteger(a);
        System.out.println(reverse);
    }

    private static int reverseInteger(int n) {
        long reverse = 0;
        int tmp = 0;
        //to reverse the number.
        while (n != 0) {
            tmp = n % 10; //pic the first elemnt
            reverse*=10; //shift the elements to the left
            reverse += tmp; //add the element
            n /= 10; // go to the next element
        }
        
          //to check if it overflows
        if (reverse > Integer.MAX_VALUE  || reverse < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reverse;
    }
    
    public int reverse(int x) {
        int b = x;
        Stack<Integer> s = new Stack<>();
        int ans= 0;
        while(b!=0){
            int dig = b%10;
            ans*=10;
            ans+=dig;
            s.push(dig);
            b/=10;
        }
        int a = ans;
         while(a!=0){
            int dig = a%10;
            int conf=  s.pop();
            if(conf != dig) return 0;
            a/=10;
        }
        
        
        return ans;
    }

}
