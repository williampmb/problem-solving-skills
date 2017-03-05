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
public class QuickInPlace {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numb = s.nextInt();
        int[] a = new int[numb];
        for (int i = 0; i < numb; i++) {
            a[i] = s.nextInt();
        }

        quickSort2Sorting(a);
    }

    private static int[] quickSort2Sorting(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        a = quickSort(a, a.length - 1, 0);
        return a;
    }

    private static int[] quickSort(int[] a, int pivot, int wall) {
        int start = wall;
        int end = pivot;
        if (a == null || pivot == wall || wall > pivot) {
            return a;
        }
        int p = a[pivot];
        for (int i = wall; i < pivot; i++) {
            if (p >= a[i]) {
                int aux = a[wall];
                a[wall] = a[i];
                a[i] = aux;
                wall++;
            }
            
        }
        if (a[pivot] < a[wall]) {
            int aux = a[wall];
            a[wall] = a[pivot];
            a[pivot] = aux;
        }

        print(a);

        a = quickSort(a, wall - 1, start);
        a = quickSort(a, end, wall + 1);

        return a;

    }

    private static void print(int[] a) {

        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println("");
    }
}
