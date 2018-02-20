/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class Permutations {
    public static void main(String[] args){
        Permutations p = new Permutations();
        int[] nums = {1,1,2,2};
        List<List<Integer>> permute = p.permute(nums);
        
        for( List<Integer> l : permute){
            for(int i : l){
                System.out.print("" + i + " ");
            }
            System.out.println("");
        }
    }
    

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int cur = 0, length = nums.length;
        List<List<Integer>> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        for (int i : nums) {
            first.add(i);
        }
        l1.add(first);
        while (cur != length - 1) {
            List<Integer> curList = l1.get(0);
            l1.remove(0);
            l2.add(curList);
            for (int i = cur + 1; i < length ; i++) {
                swap(curList,cur,i);
                l2.add(new ArrayList<>(curList));
                swap(curList,cur,i);
            }
            if(l1.isEmpty()){
                l1 = l2;
                l2 = new ArrayList<>();
                cur++;
            }
        }
        return l1;
    }

    private void swap(List<Integer> list, int i1, int i2) {
        int tmp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, tmp);
    }
}
