package tutorial.crackingthecodinginterview.datastructures;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
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
public class HeapFindtheRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        findMedia(a, n);
    }

    private static void findMedia(int[] a, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(new MyComparator());
        boolean m = true;
        NumberFormat f = new DecimalFormat("#0.0"); 
        for (int i = 0; i < n; i++) {
            double median = insert(minHeap, maxHeap, a[i], m);
            m = !m;
            System.out.println(f.format(median));
        }

    }

    private static double insert(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int i, boolean m) {
        double median;
        if (m) {
            maxHeap.add(i);
        } else {
            minHeap.add(i);
        }

        if (minHeap.size() != 0) {
            int a = maxHeap.peek();
            int b = minHeap.peek();
            if (a > b) {
                a = maxHeap.poll();
                b = minHeap.poll();
                maxHeap.add(b);
                minHeap.add(a);
            }
        }

        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            median = maxHeap.peek();
        }
        return median;
    }

    public static class MyComparator implements Comparator<Integer> {

        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }
}
