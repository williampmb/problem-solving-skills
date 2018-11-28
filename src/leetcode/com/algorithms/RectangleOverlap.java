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
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0]>=rec2[2]||rec1[1]>=rec2[3]||rec1[2]<=rec2[0]||rec1[3]<=rec2[1]) return false;
        return true;
    }
    
    //faster but same complexity
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        // upper - lower
        int height = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        // right - left
        int width = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        return height > 0 && width > 0;
    }
}
