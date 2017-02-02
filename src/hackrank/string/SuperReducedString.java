package hackrank.string;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class SuperReducedString {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        bw.write(reducedString(input));
        bw.flush();
        
    }
    
    /*
    * Time complexity O(n)
    * Space complexity O(n)
    */
    
    public static String reducedString(String inp){
        StringBuilder res = new StringBuilder();
        Stack s = new Stack();
        
        for(int i =0 ; i < inp.length(); i++){
            char charAt = inp.charAt(i);
            if(s.isEmpty()){
                s.push(charAt);
            }else if ((char) s.peek() == charAt){
                s.pop();
            }else{
                s.add(charAt);
            }
        }
        
        if(s.isEmpty()){
            return "Empty String\n";
        }
        while(!s.isEmpty()){
            res.insert(0, s.pop());
        }
        res.append("\n");
        return res.toString();
    }
}
