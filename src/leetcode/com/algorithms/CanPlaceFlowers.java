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
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return true;
        }

        int length = flowerbed.length;
        if (length == 1) {
            return flowerbed[0] == 0 ? --n <= 0 : n == 0;
        }

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 && ((i == 0 && flowerbed[i + 1] == 0)
                    || (i == length - 1 && flowerbed[i - 1] == 0)
                    || (i > 0 && i < length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0))) {
                flowerbed[i] = 1;
                n--;
                i++;
            }
        }
        return n <= 0;
    }
}
