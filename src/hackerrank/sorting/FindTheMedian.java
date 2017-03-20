package hackerrank.sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class FindTheMedian {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numbh = s.nextInt();
       
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < numbh; i++) {
            a.add(s.nextInt());
        }
        
        int median = findMedianUnsortedArray(a, (a.size()/2)+1);
        System.out.println(median);

    }

    private static int findMedianUnsortedArray(List<Integer> a, int median) {
        
        int found;
        List<Integer> left = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pick = a.get(0);
        for(int i =0; i < a.size(); i++){
            int n = a.get(i);
            if(n>pick) right.add(n);
            else if ( n == pick) eq.add(n);
            else left.add(n);
        }
        
        if(left.size()>=median)
            found = findMedianUnsortedArray(left, median);
        else if(median - left.size() <= eq.size())
            found = pick;
        else 
            found = findMedianUnsortedArray(right, median-left.size() - eq.size());
        
        return found;
    }
}
