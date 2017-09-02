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
public class PalindromeNumber {
    
    public static void main(String[] args){
        boolean palindromeNumber = palindromeNumber(999888999);
        System.out.println(palindromeNumber);
    }
    
    public static boolean palindromeNumber(int x ){
        if(x<0) return false;
        long reverse = reverseInteger(x);
        long lastNumb1 =0;
        long lastNumb2 =0;
        
        while(x != 0){
            lastNumb1 = x%10;
            lastNumb2 = reverse%10;
            if(lastNumb1 - lastNumb2 != 0) return false;
            x = x/10;
            reverse = reverse/10;
        }
        return true;
    }
    
    private static long reverseInteger(int n) {
        long reverse = 0;
        int tmp = 0;
        while (n != 0) {
            tmp = n % 10; 
            reverse*=10; 
            reverse += tmp; 
            n /= 10; 
        }
        return  reverse;
    }    
}
