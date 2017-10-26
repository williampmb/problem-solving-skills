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
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy2(49));

    }

    //extra space. How much extra space tho?
    public static boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        int xor = 0;
        xor ^= n;
        Set<Integer> db = new HashSet<Integer>();
        return isHappy(n, db);
    }

    private static boolean isHappy(int n, Set db) {
        if (n == 1) {
            return true;
        }
        if (db.contains(n)) {
            return false;
        }
        db.add(n);
        int tmp = 0;

        String spellNumb = String.valueOf(n);
        for (int i = 0; i < spellNumb.length(); i++) {
            tmp += Math.pow(Character.getNumericValue(spellNumb.charAt(i)), 2);
        }
        return isHappy(tmp, db);
    }

    //Solution with no extra space. Same technique than if an single linked list
    // has a cicle. Sometime, the runner will be at the same point(in this case)
    // than the walker. Author: Freezen from Leetcode
    public static boolean isHappy2(int n) {
        if (n < 1) {
            return false;
        }

        int runner = n, walker = n;

        do {
            runner = sumOfPowEachAlgorithms(runner);
            runner = sumOfPowEachAlgorithms(runner);
            walker = sumOfPowEachAlgorithms(walker);

        } while (runner != walker);
        if (runner == 1) {
            return true;
        }
        return false;
    }

    private static int sumOfPowEachAlgorithms(int numb) {
        int tmp = 0, sum = 0;
        while (numb != 0) {
            tmp = numb % 10;
            sum += tmp * tmp;
            numb /= 10;
        }
        return sum;
    }

}
