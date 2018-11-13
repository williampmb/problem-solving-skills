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
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if(A == null)return null;
        int r = A.length;
        int c = A[0].length;
        
        int[][] B = new int[c][r];
        for(int i = 0; i <r;i++){
            for(int j=0;j <c;j++){
                B[j][i]=A[i][j];
            }
        }
        return B;
    }
}
