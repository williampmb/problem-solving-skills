/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.hack45;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;

/**
 *
 * @author William
 */
public class SequenceEquation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Hashtable<Integer,Integer> map = new Hashtable<>();
        
        br.readLine();
        
        String input = br.readLine();
        String[] numbs = input.split(" ");
        
        for(int i = 0 ; i < numbs.length; i++){
            map.put(Integer.parseInt(numbs[i]), i+1);
        }
        
        for(int i =1 ; i < numbs.length+1;i++){
            int y = map.get(map.get(i));
            bw.write(y+"\n");
        }
        bw.flush();
    }
}
