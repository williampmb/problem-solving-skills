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
public class ZigZagConversion {
    
    public static void main(String[] args){
        String input = "ABC";
        String zag = convert(input,2);
        System.out.println(zag);
    }
    public static String convert(String s, int numRows){
        if(s == null) return null;
        if(s.length() <2 ) return s;
        if(numRows <2) return s;
        String[] lines = new String[numRows];
        for(int i = 0 ; i < lines.length;i++){
            lines[i] = new String();
        }
        int leng = s.length();
        int round = 2*numRows -2;
        
        for(int i = 0 ; i < leng ; i+=round){
            for(int j = 0 ; j < lines.length; j++){
                if(i+j >= leng) break;
                lines[j] += s.charAt(i+j);
                if(j!=0 && (j+1)%numRows != 0){
                    if(i+round-j >= leng) continue;
                    lines[j] += s.charAt(i+round-j);
                }
                   
            }
        }
        StringBuilder conc = new StringBuilder();
        for(String s2 : lines) conc.append(s2);
        return conc.toString();
    }
}
