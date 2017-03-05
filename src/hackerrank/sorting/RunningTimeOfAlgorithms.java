/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.sorting;

import java.util.Scanner;

/**
 *
 * @author William
 */
public class RunningTimeOfAlgorithms {
    //Running time for Insertion Sort
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSort(ar);
    }

    private static void insertionSort(int[] a) {
        int count = 0;
        if (a.length == 1) {
             System.out.println(count);
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int numb = a[i];
                int mov = i - 1;
                while (mov > -1 && numb < a[mov]) {
                    a[mov + 1] = a[mov];
                    mov--;
                    count++;
                }
                a[mov + 1] = numb;
            }
        }
        System.out.println(count);

    }

}
