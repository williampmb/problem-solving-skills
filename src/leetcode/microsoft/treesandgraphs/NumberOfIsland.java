/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.treesandgraphs;

/**
 *
 * @author William Barbosa
 */
public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numbIsl = 0, width = grid.length, heigth = grid[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                if (grid[i][j] == '1') {
                    numbIsl++;
                    clearIsland(grid, i, j, width, heigth);
                }
            }
        }
        return numbIsl;
    }

    private void clearIsland(char[][] grid, int i, int j, int width, int heigth) {
        if (i >= width || i < 0 || j >= heigth || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        clearIsland(grid, i + 1, j, width, heigth);
        clearIsland(grid, i - 1, j, width, heigth);
        clearIsland(grid, i, j + 1, width, heigth);
        clearIsland(grid, i, j - 1, width, heigth);
    }
}
