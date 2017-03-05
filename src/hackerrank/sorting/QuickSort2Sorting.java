/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author William
 */
public class QuickSort2Sorting {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numb = s.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < numb; i++) {
            a.add(s.nextInt());
        }

        quickSort2Sorting(a);
    }

    private static List<Integer> quickSort2Sorting(List<Integer> a) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (a == null || a.size() == 0|| a.size() == 1) {
            return a;
        }
        int p = a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if (p > a.get(i)) {
                left.add(a.get(i));
            } else if (p == a.get(i)) {
                equal.add(a.get(i));
            } else {
                right.add(a.get(i));
            }
        }

        left = quickSort2Sorting(left);
        right = quickSort2Sorting(right);

        a = new ArrayList<>();

        a.addAll(left);
        a.addAll(equal);
        a.addAll(right);
        print(a);
        return a;

    }

    private static void print(List<Integer> array) {
        if(array.size() == 1 || array == null) return;
        for(int e : array) System.out.print(e + " ");
        System.out.println("");
    }
}
