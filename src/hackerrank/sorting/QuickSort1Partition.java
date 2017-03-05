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
public class QuickSort1Partition {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numb = s.nextInt();
        int[] a = new int[numb];
        for (int i = 0; i < numb; i++) {
            a[i] = s.nextInt();
        }

        quickSortIPartition(a);
    }

    private static void quickSortIPartition(int[] a) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if(a == null || a.length==0 ) return;
        int p = a[0];
        for(int i =0; i < a.length;i++){
            if(p>a[i]) left.add(a[i]);
            else if ( p==a[i]) equal.add(a[i]);
            else right.add(a[i]);
        }
        
        for(int e : left ) System.out.print(e+" ");
        for(int e : equal ) System.out.print(e+" ");
        for(int e : right ) System.out.print(e+" ");
        System.out.println("");
    }
}
