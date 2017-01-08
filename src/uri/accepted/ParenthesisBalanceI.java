package uri.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class ParenthesisBalanceI {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        String input = br.readLine();
        while(input != null && !input.equals("")){
            String check = parenthesisCheck(input);
            result.append(check+"\n");
            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
        
    }

    private static String parenthesisCheck(String a) {
      int left= 0;
      int right =0;
      for(char c: a.toCharArray()){
          if(c == '(') left++;
          
          if(c == ')') right++;
          if(right>left) return "incorrect";
      }
      if(right!=left) return "incorrect";
      else return "correct";
    }
}
