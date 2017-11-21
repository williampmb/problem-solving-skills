/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author willi
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        Set<Integer> sister = new HashSet<Integer>();
        int candiesType = 0;
        int numbCandies = candies.length;

        // everytime that it finds a new candies, it gives to the sister
        // the maximum number of different kinds of candies it is the half of the
        // array because it needs to divide by 2 the amount of candies.
        for (int i : candies) {
            if (!sister.contains(i)) {
                sister.add(i);
                candiesType++;
                if (candiesType >= numbCandies/2) {
                    return numbCandies/2;
                }
            }
        }
        return candiesType;
    }
}
