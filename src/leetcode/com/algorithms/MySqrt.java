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
public class MySqrt {
    public static void main(String[] args){
        MySqrt sqr = new MySqrt();
        System.out.println(sqr.mySqrtIntegerNewton(65));
    }
    
    //Integer Newton
    //https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
    public int mySqrtIntegerNewton(int x){
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
    
    //Binary Search solution
    // The idea is the reduction of the possibles by half every iteration
    public int mySqrt(int x) {
        long rangeR = x, rangeL = 0;
        
        while(rangeR != rangeL && Math.abs(rangeR-rangeL) != 1){
            long powR = rangeR*rangeR;
            if(powR == x) return (int) rangeR;
            long mid = (rangeR+rangeL)/2;
            long powMid = mid*mid;
            if(powMid>x){
                rangeR = mid;
            }else if(powMid <x){
                rangeL = mid;
            }else{
                return (int) mid;
            }
        }
        
        if(rangeR*rangeR > x) return (int) (rangeR-1);
        else return (int) rangeR;
        
    }
}
