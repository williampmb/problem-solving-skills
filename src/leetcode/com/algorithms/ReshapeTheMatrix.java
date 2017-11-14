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
public class ReshapeTheMatrix {

    public static void main(String[] args) {

        ReshapeTheMatrix r = new ReshapeTheMatrix();
        int[][] nums = {{1, 2}, {3, 4}};

        int[][] a = r.matrixReshape(nums, 2, 4);

        for (int i = 0; i < a.length; i++) {
            Utils.printArrayInt(a[i]);
        }
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }

        int[][] reshape = new int[r][c];
        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                reshape[rowCount][colCount] = nums[i][j];
                colCount++;
                if (colCount == c) {
                    rowCount++;
                    colCount = 0;
                }

            }
        }
        return reshape;
    }

    //One loop but it has same complexity
    //We can use matrix[index / width][index % width] for both the input and the output matrix.
    //Author: StefanPochmann
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n) {
            return nums;
        }
        int[][] reshaped = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            reshaped[i / c][i % c] = nums[i / n][i % n];
        }
        return reshaped;
    }

}
