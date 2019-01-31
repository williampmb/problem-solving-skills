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
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int half = col % 2 == 0 ? col / 2 : col / 2 + 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < half; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][col - j - 1];
                A[i][col - j - 1] = tmp;

                A[i][j] = (A[i][j] + 1) % 2;
                if (j != col - j - 1) {
                    A[i][col - j - 1] = (A[i][col - j - 1] + 1) % 2;
                }

            }
        }

        return A;
    }
}
