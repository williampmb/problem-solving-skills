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
public class ConvertANumberToHexadecimal {
    public static void main(String[] args){
        ConvertANumberToHexadecimal c = new ConvertANumberToHexadecimal();
        
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(c.toHex(26));
    }
    
    
    public String toHex(int num) {
        int mask = 15;
        StringBuilder hexBuilder = new StringBuilder();
        for(int i = 28 ; i >= 0;i -=4){
            int gap = (num>>>i)&mask;
            if(gap==0 && hexBuilder.length() == 0) continue;
            String hex = getValue(gap);
            hexBuilder.append(hex);
        }
        String hexacimal = hexBuilder.toString();
        if(hexacimal.length() == 0)return "0";
        
        return hexacimal;
    }

    private String getValue(int gap) {
        if(gap < 10){
            return ""+gap;
        }
        int offset = gap%10;
        char value = (char)(offset+'a');
        return value+"";
    }
}
