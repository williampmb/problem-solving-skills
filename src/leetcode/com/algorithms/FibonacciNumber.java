/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class FibonacciNumber {
   public int fib(int N) {
       int n1 =1, n2 = 0;
        if(N == 0) return n2;
        if(N == 1) return n1;
        while(N>1){
            int tmp = n2+n1;
            n2 = n1;
            n1 = tmp;
            N--;
        }
        return n1;
    
    } 
}
