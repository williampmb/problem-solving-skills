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
public class RangeAdditionII {
    
    public static void main(String[] args){
        RangeAdditionII r = new RangeAdditionII();
        int[][] ops = {{2,4},{3,3}};
        System.out.println(r.maxCount(3, 3, ops));
    }
    
    //We don't need to execute any of operations.
    // We just need to know that every single operations will add 1 from 0 up to a-1 or b-1
    // which means that if we pick the lowest ops we will know the largest number
    // and if we do the min of a* min of b we will have how many times the number appears.
    public int maxCount(int m, int n, int[][] ops) {
        int aMin =Integer.MAX_VALUE, bMin =Integer.MAX_VALUE;
        
        for(int i = 0 ; i <ops.length; i++){
            int a = ops[i][0];
            int b = ops[i][1];
            if(aMin > a)aMin = a;
            if(bMin > b)bMin = b;
        }
        
        if(aMin > m)aMin = m;
        if(bMin > n)bMin = n;
        
        return aMin*bMin;
    }
}
