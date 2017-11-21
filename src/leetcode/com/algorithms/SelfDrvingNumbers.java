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
public class SelfDrvingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        while(left <= right){
            if(isSelfDriving(left)) result.add(left);
            left++;
        }
        return result;
    }

    private boolean isSelfDriving(int left) {
        int numb = left;
        while(left!= 0){
            int digit = left%10;
            if(digit == 0 || !(numb%digit==0) ) return false;
            left /=10;
        }
        return true;
    }
}
