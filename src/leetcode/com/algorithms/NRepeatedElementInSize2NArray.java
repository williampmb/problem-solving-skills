/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author William Barbosa
 */
public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++){
            if (numbers.contains(A[i])){
                return A[i];
            }
            
            numbers.add(A[i]);
        }
        
        return 0;
    }
}
