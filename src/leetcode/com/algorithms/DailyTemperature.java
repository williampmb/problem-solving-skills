/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Stack;

/**
 *
 * @author William Barbosa
 */
//@author: luckman at leetcode
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures){
        int[] toWamer = new int[temperatures.length];
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0 ; i < temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] >temperatures[st.peek()]){
                int idOld = st.pop();
                toWamer[idOld] = i - idOld;
            }
            st.push(i);
        }
        return toWamer;
    }
}
