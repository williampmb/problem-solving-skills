/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

/**
 *
 * @author William Barbosa
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] height = {9,6,8,8,5,6,3};
        //int[] height = {4, 3, 3, 9, 3, 0, 9, 10, 13, 2, 8, 3};
        int trap = t.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int left = 0, right = height.length - 1, sumWater = 0;

        while (left < height.length - 1 && height[left] <= height[left + 1]) {
            left++;
        }

        while (right > 1 && height[right] <= height[right - 1]) {
            right--;
        }

        while (left < right) {
            int wall = left + 1;

            while (wall < right && height[wall] < height[left]) {
                if (height[wall] == height[left]) {
                    break;
                }
                wall++;
            }

            int max = -1;
            int maxPos = -1;
            int pos1 = left + 1;

            while (pos1 < wall) {
                if (max < height[pos1]) {
                    max = height[pos1];
                    maxPos = pos1;
                }
                pos1++;
            }

            if (max > height[wall] && max < height[left]) {
                wall = maxPos;
            }

            int pos = left + 1;
            int minWall = height[left] > height[wall] ? height[wall] : height[left];

            while (pos < wall) {
                int water = minWall - height[pos];
                if (water > 0) {
                    sumWater += water;
                }
                pos++;
            }
            left = wall;
        }
        return sumWater;
    }
}
