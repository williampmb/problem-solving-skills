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
public class DiamondsAndSand1069 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(br.readLine());
        while(testCases != 0){
            String terrain = br.readLine();
            int diamonds = findDiamonds(terrain);
            bw.write(diamonds + "\n");
            
            testCases--;
        }
        bw.flush();
    
    }
    
    public static int findDiamonds(String terrain){
        int piece =0;
        int diamonds =0;
        for(int i = 0; i < terrain.length(); i++){
            if(terrain.charAt(i) == '<') piece++;
            else if(terrain.charAt(i) == '>' && piece >0){
                diamonds++;
                piece--;
            }
        }
        return diamonds;
        
    }
    
}
