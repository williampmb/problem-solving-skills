/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
             
                if(o1[0]== o2[0]) return Integer.compare(o1[1],o2[1])*-1;//*-1 inverts the same height order
                return Integer.compare(o1[0],o2[0]);
            }
        });
        
        List<int[]> ans = new ArrayList<>(people.length);
        for(int i = people.length-1; i>=0 ;i--){
            ans.add(people[i][1],people[i]); // put in the people[i][1] order ahead the list because the right part will be ordered. 
        }
        
        return ans.toArray(people);
    }
    
    
    //TLE
    public static Integer[][] reconstructQueue2(Integer[][] people) {
        
        Arrays.sort(people, new Comparator<Integer[]>(){

            @Override
            public int compare(Integer[] o1, Integer[] o2) {
             
                if(o1[0].compareTo(o2[0])==0) return o1[1].compareTo(o2[1]);
                return o1[0].compareTo(o2[0]);
            }
        });
        int cur = 0, l = people.length;
        while(cur<l){
            int count =0,curl = cur-1;
            while(curl>=0){
                if(people[cur][0].compareTo(people[curl][0])<=0){
                    count++;
                  
                }
                  curl--;
            }
            int moves = people[cur][1]- count;
            int tmpCur = cur;
            while(moves>0 && tmpCur<l){
                if(people[tmpCur][0].compareTo(people[tmpCur+1][0])<=0){
                    moves--;
                }
                Integer[] tmp = people[tmpCur];
                people[tmpCur] = people[tmpCur+1];
                people[tmpCur+1] = tmp;
                tmpCur++;
            }
            
            if(tmpCur == cur) cur++;
        }
        return people;
    }
    
    public static Integer[][] toObject(int[][] intArray) {

		Integer[][] result = new Integer[intArray.length][2];
		for (int i = 0; i < intArray.length; i++) {
			result[i][0] = intArray[i][0];
                        result[i][1] = intArray[i][1];
		}
		return result;
	}
    
    public static int[][] toPrimitive(Integer[][] IntegerArray) {

		int[][] result = new int[IntegerArray.length][2];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i][0] = IntegerArray[i][0];
                        result[i][1] = IntegerArray[i][1];
		}
		return result;
	}
}
