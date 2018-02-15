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
public class ToeplitzMatrix {
    
    public static void main(String[] args){
        ToeplitzMatrix t = new ToeplitzMatrix();
        int[][] mat = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean toeplitzMatrix2 = t.isToeplitzMatrix2(mat);
        System.out.println(toeplitzMatrix2);
    }

    public boolean isToeplizMatrix(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            int j = 0 , row = i;
            while(row < rows-1 && j < cols-1){
                if(matrix[row][j] != matrix[row+1][j+1]) return false;
                row++;
                j++;
            }
        }
        
        for(int i = 0 ; i < cols ; i++){
            int j = 0, col =i;
            while(col < cols -1 && j < rows-1){
                if(matrix[j][col] != matrix[j+1][col+1]) return false;
                col++;
                j++;
            }
        }
        return true;
    }
    
    //Author: shawngao at leetcode
    // check if every element is equal than next diagonal element
    public boolean isToeplitzMatrix2(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if ( matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
}
