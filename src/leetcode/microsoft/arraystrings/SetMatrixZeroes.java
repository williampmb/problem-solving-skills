/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

/**
 *
 * @author William Barbosa
 */
public class SetMatrixZeroes {
    
    public static void main(String[] args){
        SetMatrixZeroes s = new SetMatrixZeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        s.setZeroes(matrix);
        
    }

    public void setZeroes(int[][] matrix) {
        boolean line = false, column = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                line = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                column = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (line) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (column) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
