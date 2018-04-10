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
public class MaxAreaOfIsland {
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    area = sumArea(grid, i, j);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    private int sumArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 0;
        area += sumArea(grid, i - 1, j);
        area += sumArea(grid, i + 1, j);
        area += sumArea(grid, i, j - 1);
        area += sumArea(grid, i, j + 1);

        return area;
    }
}
