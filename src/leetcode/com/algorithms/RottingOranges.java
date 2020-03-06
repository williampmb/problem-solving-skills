package leetcode.com.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        orangesRotting(grid);
    }

    static public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;
        int elapse = -1;
        Queue<int[]> rotten = new LinkedList<>();
        Queue<int[]> rottenNext = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[] { i, j });
                }
            }
        }

        while (!rotten.isEmpty()) {
            int[] orange = rotten.poll();

            int x = orange[0] + 1, y = orange[1];
            neighoodRotten(rottenNext, x, y, grid, rows, cols);
            x = orange[0] - 1;
            y = orange[1];
            neighoodRotten(rottenNext, x, y, grid, rows, cols);
            x = orange[0];
            y = orange[1] + 1;
            neighoodRotten(rottenNext, x, y, grid, rows, cols);
            x = orange[0];
            y = orange[1] - 1;
            neighoodRotten(rottenNext, x, y, grid, rows, cols);

            if (rotten.isEmpty()) {
                if (!rottenNext.isEmpty()) {
                    elapse++;
                }
                rotten = rottenNext;
                rottenNext = new LinkedList<>();
            }

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ++elapse;
    }

    static public void neighoodRotten(Queue<int[]> rotten, int x, int y, int[][] grid, int rows, int cols) {
        if (!outOfBoundaries(x, y, rows, cols) && isFreshOrange(grid[x][y])) {
            rotten.add(new int[] { x, y });
            grid[x][y] = 2;
        }
    }

    static public boolean outOfBoundaries(int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col)
            return true;
        return false;
    }

    static public boolean isFreshOrange(int orange) {
        return orange == 1;
    }
}