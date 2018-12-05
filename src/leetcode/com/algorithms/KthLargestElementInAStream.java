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

    
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int k = 0;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int n : nums) arr.add(n);
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - k);
    }
}
