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
public class PowerOfTwo {
    public static void main(String[] args){
        
    }
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        return (n&(n-1)) == 0;    
    }
}
