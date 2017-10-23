/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willi
 */
public class PascalsTriangle {
    public static void main(String[] args){
        PascalsTriangle pt = new PascalsTriangle();
        
        List<List<Integer>> generate = pt.generate(5);
        
        print(generate);
        
    }

    private static void print(List<List<Integer>> generate) {
        for(List<Integer> l : generate){
            System.out.print("[");
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if (numRows == 0) {
            List<Integer> empty = new ArrayList<>();
            list.add(empty);
            return list;
        }
        List<Integer> one = new ArrayList<>();
        one.add(1);
        list.add(one);
        if (numRows == 1) {
            return list;
        }
        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        list.add(two);

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> previous = list.get(i - 1);
                int element = previous.get(j - 1) + previous.get(j);
                row.add(element);
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
