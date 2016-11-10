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
}
