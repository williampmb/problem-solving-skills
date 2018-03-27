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
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {{1, 4, 1}, {2, 7, 6}, {4, 2, 1}};
        m.minPathSum(grid);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[row - 1][col - 1];
    }
}
