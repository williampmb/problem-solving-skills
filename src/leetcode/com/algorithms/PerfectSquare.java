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
public class PerfectSquare {
    
    public static void main(String[] args){
    
        PerfectSquare p = new PerfectSquare();
        int a = 74;
        boolean is = p.isPerfectSquare(a);
        System.out.println(is);
    }
    
    
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num, x = (left+num)/2;
        
        while(left <= right){
            if(x*x == num) return true;
            else if(x*x > num){
                right = x-1;
            }else {
                left = x+1;
            }
            x = (left+right)/2;
        }
        return false;
    }
}
