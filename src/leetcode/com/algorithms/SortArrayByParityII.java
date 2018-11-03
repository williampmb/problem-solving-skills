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
public class SortArrayByParityII {
    /*
    *   O(n) Time complexity
    *   O(1) Space complexity
    *   It solves the problem in-place
    */
    public int[] sortArrayByParityII(int[] A) {
       int odd =0, even=1, size = A.length-1;
        while(odd<size){
            if(A[odd]%2==1){
                even = nextOdd(even,A);
                swap(odd,even,A);
                even+=2;
            }
            odd+=2;
        }
        return A;
    }
    
    public int nextOdd(int pos, int[] A){
        while(A[pos]%2==1){
            pos+=2;
        }
        return pos;
    }
    
    public void swap(int a, int b, int[] A){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
