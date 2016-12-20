/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codepit.io.cafecomleite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author William
 */
public class GoogleIsFeelingLucky {
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new FileReader("src/codepit/io/cafecomleite/input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder test = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String input = br.readLine();
        int testCase = Integer.valueOf(input);
        int max =-1, line = -1;
        int count = 0;
        while(testCase != count && testCase >0){
            
            for(int i =0; i < 10; i++){
                input = br.readLine();
                String[] tk = input.split(" ");
                line = Integer.valueOf(tk[1]);
                if(line >max){
                    test = new StringBuilder();
                    test.append(tk[0] + "\n");
                    max = line;
                }else if(line == max){
                    test.append(tk[0] + "\n");
                }
            }
            
            if(max < 0 ){
                test.append("");
            }
            line = -1;
            max = -1;
            count++;
            result.append("Case #" + count + ":\n");
            result.append(test.toString());
            
        }
        
        bw.write(result.toString());
        bw.flush();
    }
}
