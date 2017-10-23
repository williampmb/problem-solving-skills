/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author willi
 */
public class PascalsTriangle2 {

    public static void main(String[] args) {
        PascalsTriangle2 pt = new PascalsTriangle2();

        List<Integer> generate = pt.getRow(3);

        print(generate);

    }

    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];

        row[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j >= 1; j--) {
                row[j] += row[j - 1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : row) {
            list.add(i);
        }
        return list;
    }

    //O(K) space. However, not very good complexity in running time O(N^k)
    // if we use a hashtable to keep the calculated values it will increase the
    // space complexity though.
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> kth = new ArrayList<>();
        if (rowIndex < 0) {
            return kth;
        }
        kth.add(1);
        if (rowIndex == 0) {
            return kth;
        }
        kth.add(1);
        int count = 2;
        int range = (rowIndex + 1) % 2 == 0 ? (rowIndex + 1) / 2 : ((1 + rowIndex) / 2) + 1;
        for (int i = 1; i < range; i++) {
            int element = getElementFromPrevious(i, rowIndex);

            if (count == rowIndex) {
                kth.add(i, element);
            } else {
                kth.add(i, element);
                kth.add(kth.size() - i, element);
                count += 2;
            }

        }
        return kth;
    }

    private int getElementFromPrevious(int i, int rowIndex) {
        if (i > rowIndex) {
            return 0;
        }
        if (i < 1 || rowIndex < 2) {
            return 1;
        }
        return getElementFromPrevious(i - 1, rowIndex - 1) + getElementFromPrevious(i, rowIndex - 1);
    }

    private static void print(List<Integer> generate) {
        System.out.print("[");
        for (Integer i : generate) {
            System.out.print(i + " ");
        }
        System.out.println("]");

    }
}
