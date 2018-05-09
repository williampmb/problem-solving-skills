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
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int row = matrix.length, col =matrix[0].length;
        if(target < matrix[0][0] && target > matrix[row-1][col-1]) return false;
        
        int rowIni = 0, rowEnd = row-1, rowMid =0;
        while(rowIni < rowEnd){
            rowMid = (rowIni+rowEnd)/2;
            if(target > matrix[rowMid][col-1]){
                rowIni = rowMid+1;
            }else if(target < matrix[rowMid][col-1]){
                rowEnd = rowMid-1;
            }else{
                return true;
            }
        }
        
        int atRow = target < matrix[rowIni][col-1] ? rowIni : rowIni+1;
        int colIni = 0, colEnd = col-1, colMid = 0;
        
        while(colIni < colEnd){
            colMid = (colIni+colEnd)/2;
            if(target > matrix[atRow][colMid]){
                colIni = colMid+1;
            }else if(target < matrix[atRow][colMid]){
                colEnd = colMid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
