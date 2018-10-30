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
public class FindSmallestLetterGreaterThanTarget {
    
    /*
    * Time complexity: O(log n)
    * Space complexity: O(1)
    */
    public char nextGreatestLetter(char[] letters, char target) {
        int m=0, s=0,e=letters.length-1;
        while(s<e){
            m=(s+e)/2;
            if(target>=letters[m])s=m+1;
            else e=m;
                
        }
        if(s==letters.length-1 && target < letters[s] ) return letters[s];
        if(s>=letters.length-1 || (s==0 && target<letters[0])) return letters[0];
        
        return letters[s];
    }
    
    /*
    * Knowing that the array is maximum 2000 length
    * We could use O(N) complexity
    */
    
    public char nextGreatestLetter2(char[] letters, char target){
        //all possible letters between 'a' and 'z'
        boolean[] haveSeen = new boolean[26];
        for(char c : letters) haveSeen[c-'a'] =true;
        //it garanties that it won't be infinity loop because it will have at least 2 elements
        while(true){
            //check the next smaller value greater than target
            target++;
            //if target get out of boundaries target > z, return to the begin 'a'
            if(target > 'z') target ='a';
            //if we have seen where the current target is, it is the choosen 
            if(haveSeen[target-'a']) return target;
        }
    }
}
