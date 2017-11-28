package uri.accepted;


import java.io.FileReader;

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
public class CompareSubstring_1237 {

    public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        String input1, input2;
        input1 = br.readLine();
        int subLenght, subStr, count;
        boolean match = false;

        while (input1 != null && !input1.equals("")) {
            input2 = br.readLine();
            subLenght = 0;
            subStr = 0;

            for (int i = 0; i < input1.length(); i++) {
                for (int j = 0; j < input2.length(); j++) {
                    if(i+subStr >input1.length()-1){
                        break;
                    }
                    if ((int) input1.charAt(i + subStr) == (int) input2.charAt(j)) {

                        subStr++;
                        match = true;
                        if (subStr > subLenght) {
                            subLenght = subStr;
                        }
                    } else {
                        if(match){
                            j--;
                            match = false;
                        }
                        subStr = 0;
                    }
                }
                subStr=0;
                match=false;
            }
            result.append(subLenght + "\n");
            input1 = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
    }
    
    //Dynamic programing
    public static void main2(String[] args) throws IOException {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        int[][] match;
        String s1 = br.readLine();
        while (s1 != null && !s1.equals("")) {
            String s2 = br.readLine();
            match = new int[50][50];
            int len1 = s1.length();
            int len2 = s2.length();
            int max = 0;

            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        if (i != 0 && j != 0) {
                            match[i][j] = match[i - 1][j - 1] + 1;
                        } else {
                            match[i][j] = 1;
                        }
                        if (match[i][j] > max) {
                            max = match[i][j];
                        }
                    }
                }
            }
            output.append(max + "\n");
            s1 = br.readLine();
        }
        bw.write(output.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    
}
