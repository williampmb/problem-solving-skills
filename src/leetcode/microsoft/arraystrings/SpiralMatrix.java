/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{2, 0, 3},{7, 8, 9}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 1, 9}, {1, 4, 2}, {5, 2, 0}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = {{1, 2, 3, 5, 7}, {4, 5, 6, 7, 5}};
        List<Integer> spiralOrder = s.spiralOrder(matrix);
        for (int i : spiralOrder) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length, cols = matrix[0].length;
        int layer = 0;
        List<Integer> ans = new ArrayList<>();

        int maxL = cols > rows ? rows : cols;
        maxL = maxL % 2 == 1 ? maxL + 1 : maxL;
        while (layer < maxL / 2) {

            //left to right 
            for (int i = layer; i < cols - layer; i++) {
                ans.add(matrix[layer][i]);
            }

            //top to bottom
            for (int i = layer + 1; i < rows - layer; i++) {
                ans.add(matrix[i][cols - layer - 1]);
            }

            //right to left
            if (layer <= rows - 1 - layer - 1) {
                for (int i = cols - 1 - layer - 1; i >= layer; i--) {
                    ans.add(matrix[rows - 1 - layer][i]);
                }
            }

            //bottom to top
            if (layer <= cols - 1 - layer - 1) {
                for (int i = rows - 1 - layer - 1; i > layer; i--) {
                    ans.add(matrix[i][layer]);
                }
            }

            layer++;
        }

        return ans;
    }
}
