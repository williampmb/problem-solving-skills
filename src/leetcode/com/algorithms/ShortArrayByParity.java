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
public class ShortArrayByParity {
    
    //O(n) Space and time complexity
   public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int start =0, end =A.length-1;
        
        for(int i = 0; i < A.length;i++){
            if(A[i]%2==0) ans[start++]=A[i];
            else ans[end--]=A[i];
        }
        
        return ans;
    }
   
   //O(n) time complexity
   //O(1) space complexity
   public int[] sortArrayByParity2(int[] A) {
        
        int start =0, end =A.length-1;
        while(start<end){
            if(A[start]%2==1 && A[end]%2==0){
                swap(start,end,A);//TODO
            }else if(A[start]%2==0){
                start++;
            }else if(A[start]%2==1){
                end--;
            }
        }
        return A;
    }
    
    public void swap(int s,int e, int[] a){
        int tmp = a[s];
        a[s] = a[e];
        a[e] = tmp;
    }
}
