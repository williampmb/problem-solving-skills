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
public class ImageSmoother {

    public static void main(String[] args) {
        ImageSmoother i = new ImageSmoother();
        int[][] m = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] in = i.imageSmoother(m);

        for (int ib = 0; ib < m.length; ib++) {
            Utils.printArrayInt(in[ib]);
        }

    }

    //O(n*m) space complexity. We can improve it using some bits to store the new
    // value and in the end we shift the bits to the valid positions.
    // a int has 32 bits and the question says the maximum value is 255 which it
    // is up to 8 bits.
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;

        int[][] smoother = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                int sum = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if (isValid(i + x, j + y, M)) {
                            count++;
                            sum += M[i + x][j + y];
                        }
                    }
                }
                smoother[i][j] = (int) (Math.floor(sum / count));
            }
        }

        return smoother;

    }

    private boolean isValid(int x, int y, int[][] M) {
        int width = M.length;
        int height = M[0].length;

        return width > x && x >= 0 && height > y && y >= 0;
    }
    
    //
}
