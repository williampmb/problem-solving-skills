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
public class Alliteration_1263 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        int compare, count, selectedWord;
        boolean alliteration = true;
        while (input != null && !input.equals("")) {
            String[] words = input.split(" ");
            compare = 0;
            count =0;
            for (String w : words) {
                selectedWord = (int) w.charAt(0);
                if (selectedWord > 64 & selectedWord < 91) {
                    selectedWord += 32;
                }
                if (compare == selectedWord) {
                    if (alliteration) {
                        count++;
                        alliteration = false;
                    }
                } else {
                    alliteration = true;
                }
                compare = selectedWord;
            }
            result.append(count + "\n");
            input = br.readLine();
        }
        bw.write(result.toString());
        bw.flush();
    }
}
