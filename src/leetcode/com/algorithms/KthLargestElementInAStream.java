/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author William Barbosa
 */
public class KthLargestElementInAStream {
    public static void main(String[] args) {
        int[] nums = {-10,1,3,1,4,10,3,9,4,5,1};
        KthLargest k = new KthLargest(7, nums);

        int ans = k.add(3);
        System.out.println(ans);
        ans = k.add(2);
        System.out.println(ans);
        ans = k.add(3);
        System.out.println(ans);
        ans = k.add(1);
        System.out.println(ans);
        ans = k.add(2);
        System.out.println(ans);
        
         ans = k.add(4);
        System.out.println(ans);
        ans = k.add(5);
        System.out.println(ans);
        ans = k.add(5);
        System.out.println(ans);
        ans = k.add(6);
        System.out.println(ans);
        ans = k.add(7);
        System.out.println(ans);
        
      
        ans = k.add(7);
        System.out.println(ans);
        ans = k.add(8);
        System.out.println(ans);
        ans = k.add(2);
        System.out.println(ans);
        ans = k.add(3);
        System.out.println(ans);
        ans = k.add(1);
        System.out.println(ans);
        
         ans = k.add(1);
        System.out.println(ans);
        ans = k.add(1);
        System.out.println(ans);
        ans = k.add(10);
        System.out.println(ans);
        ans = k.add(11);
        System.out.println(ans);
        ans = k.add(5);
        System.out.println(ans);
 
        ans = k.add(6);
        System.out.println(ans);
        ans = k.add(2);
        System.out.println(ans);
        ans = k.add(4);
        System.out.println(ans);
        ans = k.add(7);
        System.out.println(ans);
        ans = k.add(8);
        System.out.println(ans);
        
         ans = k.add(5);
        System.out.println(ans);
        ans = k.add(6);
        System.out.println(ans);
    }

    public static class KthLargest {

        /*
        *   Construction: O(N * logK)
        *   Adding: O(logK)
        *
        */
        int pos;
        int[] heap;

        public KthLargest(int k, int[] nums) {
            heap = new int[k];
            pos = 0;
            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            if (pos == heap.length) {
                if (val > heap[0]) {
                    pop();
                } else {
                    return heap[0];
                }
            }
            int cur = pos;
            heap[pos++] = val;
            while (cur >= 0) {
                int dad = (cur - 1) / 2;
                if (heap[dad] <= heap[cur]) {
                    break;
                }
                swap(dad, cur, heap);
                cur = dad;
            }

            return heap[0];
        }

        private int pop() {
            int ans = heap[0];
            heap[0] = heap[--pos];
            int cur = 0;
            while (cur < pos) {
                int rightChild;
                int leftChild;
                if (cur * 2 + 1 < pos && cur * 2 + 2 < pos) {
                    rightChild = heap[cur * 2 + 2];
                    leftChild = heap[cur * 2 + 1];
                    if (leftChild <= rightChild) {
                        if (heap[cur] >= heap[cur * 2 + 1]) {
                            swap(cur * 2 + 1, cur, heap);
                            cur = cur * 2 + 1;
                        } else {
                            break;
                        }
                    }else{
                        if (heap[cur] >= heap[cur * 2 + 2]) {
                            swap(cur * 2 + 2, cur, heap);
                            cur = cur * 2 + 2;
                        } else {
                            break;
                        }
                    }
                    
                } else {
                    if (cur * 2 + 1 < pos && heap[cur] > heap[cur * 2 + 1]) {
                        swap(cur * 2 + 1, cur, heap);
                        cur = cur * 2 + 1;
                    } else {
                        break;
                    }
                }

            }
            return ans;
        }

        private void swap(int dad, int cur, int[] heap) {
            int tmp = heap[dad];
            heap[dad] = heap[cur];
            heap[cur] = tmp;
        }
    }

    ArrayList<Integer> arr = new ArrayList<Integer>();
    int k = 0;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            arr.add(n);
        }
    }

    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - k);
    }
}
