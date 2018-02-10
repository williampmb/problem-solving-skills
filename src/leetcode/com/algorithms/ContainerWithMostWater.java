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
public class ContainerWithMostWater {
    
    //Note: You may not slant the container and n is at least 2.
    public int maxArea(int[] height) {
        int left =0, right = height.length-1, maxArea=0;
        
        while(left < right){
            maxArea = Math.max(maxArea, rectangleArea(height[left],left,height[right],right));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    private int rectangleArea(int h1, int b1, int h2, int b2) {
       return Math.min(h1,h2)*(b2-b1);
    }
}
