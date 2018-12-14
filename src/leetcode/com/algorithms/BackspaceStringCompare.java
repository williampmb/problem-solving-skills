/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 * 
 * O(1) space complexity
 * O(N) time complexity
 */
public class BackspaceStringCompare {
    public static void main(String[] args){
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        
        bsc.backspaceCompare("a#c", "b");
        
    }
    
    public boolean backspaceCompare(String S, String T) {
        int ps = S.length()-1, pt = T.length()-1;
        while(ps>=0 && pt>=0){
            char cs = S.charAt(ps);
            char ct = T.charAt(pt);
            if(cs == '#' ||ct == '#'){
                ps = delete(S,ps);
                pt = delete(T,pt);
            }else if(cs ==ct){
                ps--;
                pt--;
            }else{
                return false;
            }
        }
         ps = delete(S,ps);
         pt = delete(T,pt);
        return ps<0 && pt<0;
    }
    
    public int delete(String s, int pos){
        int d =0;
        if(pos>=0 && s.charAt(pos)=='#'){
            d++;
            pos--;
        }
        while(pos>=0 && (d>0 || s.charAt(pos) =='#')){
            char c = s.charAt(pos);
            if(c == '#')
                d++;
            else{
                d--;
            }
             pos--;
        }
        return pos;
        
    }    
}
