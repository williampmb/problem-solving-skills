/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Arrays;

/**
 *
 * @author William Barbosa
 */
public class UniquePathII {
    
    public static void main(String[] args){
        UniquePathII u = new UniquePathII();
        int[][] obstacleGrid = {{0,0,0},{0,0,0},{0,0,0}};
        int uniquePathsWithObstacles4 = u.uniquePathsWithObstacles4(obstacleGrid);
        System.out.println(uniquePathsWithObstacles4);
        
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                } else if (j == 0 || i == 0) {
                    obstacleGrid[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == -1 || (obstacleGrid[i - 1][j] == -1 && obstacleGrid[i][j - 1] == -1)) {
                    continue;
                } else if (obstacleGrid[i][j - 1] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }

        }

        return obstacleGrid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 || n == 1) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            obstacleGrid[i][0] = -1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            obstacleGrid[0][j] = -1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1 || (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1)) {
                    obstacleGrid[i][j] = 0;
                } else if (obstacleGrid[i][j - 1] == 1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == 1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }

        return -1 * obstacleGrid[m - 1][n - 1];
    }

    //@tusizi at leetcode
    /* The reason it works is because every time that iterates it depends just
    * on the top that it is the right position d[j] and the left position which
    * is d[j-1].
    * It is more clean but it uses O(width) space complexity
     */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    //In my view the best and clear solution. O(1) space complexity
    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //nice trick
        obstacleGrid[0][0] ^= 1;
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 1) ? 0 : obstacleGrid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
