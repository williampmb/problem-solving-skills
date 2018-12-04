/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int max =0, count =0, s=seats.length,pos=0;
        
        while(pos<s && seats[pos] ==0){
            max++;
            pos++;
        }
        while(pos<s){
            if(seats[pos]==0){
                count++;
                pos++;
            }else{
                max = Math.max(count/2,max);
                count=0;
                pos++;
            }
        }
        
        return Math.max(count,max); 
    }
}
