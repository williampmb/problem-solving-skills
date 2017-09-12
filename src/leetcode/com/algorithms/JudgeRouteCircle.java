/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int vertical=0, horizontal =0;
        
        for(char c : moves.toCharArray()){
            if(c == 'R') horizontal++;
            if(c == 'L') horizontal--;
            if(c == 'U') vertical++;
            if(c == 'D') vertical--;
        }
        if(horizontal ==0 && vertical == 0) return true;
        return false;
    }
}
