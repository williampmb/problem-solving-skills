package hackerrank.worldcodespring9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author William
 * 
 */
public class WeightedUniformStrings {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
        String s = br.readLine();
        Map<Integer, Integer> map = weightedString(s);
        StringBuilder res = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int a0 = 0; a0 < n; a0++) {
            int x = Integer.parseInt(br.readLine());

            if (map.get(x) != null) {
                res.append("Yes\n");
            } else {
                res.append("No\n");
            }
        }
        bw.write(res.toString());
        bw.flush();
    }

    public static Map<Integer, Integer> weightedString(String input) {
        Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
        int tam = input.length();
        int count = 1;
        if(tam == 0){
            return map;
        }
        
        if(tam == 1){
            map.put(count * (input.charAt(0) - 96), 0);
            return map;
        }
        
        for (int i = 1; i < input.length(); i++) {
            char let = input.charAt(i - 1);
            if (let == input.charAt(i)) {
                count++;
            } else {
                count = 1;
            }
            map.put(count * (let - 96), 0);
        }

        if (input.charAt(tam - 2) == input.charAt(tam - 1)) {
            count++;
        } else {
            count = 1;
        }

        map.put(count * (input.charAt(tam - 1) - 96), 0);

        return map;
    }
}
