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
public class AddStrings {
    public static void main(String[] args){
        AddStrings a = new AddStrings();
        
        String s = a.addStrings( "0","9133");
        System.out.println(s);
        
        
    }
    
    public String addStrings(String num1, String num2) {
        int s1 = num1.length(), s2 = num2.length(), count =0;
        StringBuilder res = new StringBuilder();
        int addOne=0;
        while(count < s1 && count < s2){
        	int c1 = num1.charAt(s1 -1 - count) - '0';
        	int c2 = num2.charAt(s2 -1 - count) - '0';
        	
        	int partial = c1 + c2 + addOne;
        	
        	int tmp = partial%10;
        	res.insert(0, tmp);
        	addOne = partial/10;
        	        	
        	count++;
        }
        int atS2 = count, atS1= count;
        while(atS2<s2){
        	int c2 = num2.charAt(s2 - 1 - atS2)-'0';
        	
        	int partial = c2 + addOne;
        	
        	int tmp = partial%10;
        	res.insert(0, tmp);
        	addOne = partial/10;
                atS2++;
        }
        
        while(atS1<s1){
        	int c1 = num1.charAt(s1 - 1 - atS1)-'0';
        	
        	int partial = c1 + addOne;
        	
        	int tmp = partial%10;
        	res.insert(0, tmp);
        	addOne = partial/10;
                atS1++;
        }
        
        if(addOne >0){
        	res.insert(0, addOne);
        }
        
        return res.toString();
    }
    
    //Author: ZachC  at leetcode
    // Same algorithm but cleaner and simpler
    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
