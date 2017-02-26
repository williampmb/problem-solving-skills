package hackerrank.worldcodespring9;


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
public class GradingStudents {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int grades = Integer.parseInt(br.readLine());
        
        while(grades != 0){
            int grade = Integer.parseInt(br.readLine());
            if(grade+2>=40){
                if((grade+1)%5==0){
                    grade+=1;
                }else if((grade+2)%5==0){
                    grade+=2;
                }
                
            }
            bw.write(grade+"\n");
            grades--;
        }
        bw.flush();
    }
}
