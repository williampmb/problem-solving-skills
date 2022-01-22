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
public class MinimumNumberofOperationstoMoveAllBallstoEachBox {

    public static void main(String[] args) {
        int[] op = minOperations("1");
        
        for(int o : op){
            System.out.print(o);
        }
    }

    public static int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] left = new int[n];
        int balls = 0;
        for(int i = 1; i < n ; i++){
            balls += boxes.charAt(i-1)=='0'?0:1;
            left[i] = left[i-1]+balls;
        }
        
        int[] right = new int[n];
        balls= 0;
        for(int i = n-2; i>=0;i--){
            balls += boxes.charAt(i+1)=='0'?0:1;
            right[i] = right[i+1]+ balls;
        }
        
        int[] operations = new int[n];
        for(int i = 0 ; i < n;i++){
            operations[i] = left[i] + right[i];
        }
        
        return operations;
    }
    
   
}
