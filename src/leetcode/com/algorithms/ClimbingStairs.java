/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author willi
 */
public class ClimbingStairs {

    static Map<Integer, Integer> db = new Hashtable<Integer, Integer>();

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        int climbStairs = c.climbStairs(44);
        System.out.println(climbStairs);
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        return clibingStarts(n);
    }

    public int clibingStarts(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (db.containsKey(n)) {
            return db.get(n);
        }
        int numb = clibingStarts(n - 2);
        numb += clibingStarts(n - 1);
        db.put(n, numb);
        return numb;
    }

    //Iterative way. Based on fibonacci logic.
    // Author: liaison
    public int climbStairs2(int n) {
        // base cases
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
