/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class Utils {

    public static void printArrayInt(int[] array) {
        int size = array.length;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(array[i]);
            if (i != size - 1) {
                s.append(" - ");
            }
        }
        System.out.println(s.toString());
    }
}
