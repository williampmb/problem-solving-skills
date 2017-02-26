/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author William
 */
public class TheFullCoutingSort {

    public static void main(String[] args) throws IOException {
        //Scanner s = new Scanner(System.in);
        //Scanner s = new Scanner(new File("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int numbs = Integer.parseInt(br.readLine());
        int[] count = new int[100];
        Element[] ori = new Element[numbs];
        Element[] helper = new Element[numbs];
        int oriPos = 0, half = numbs/2;
        while (numbs != 0) {

            String line = br.readLine();
            String[] tk = line.split(" ");
            if(half>0){
                tk[1]= "-";
                half--;
            }
            Element e = new Element(Integer.parseInt(tk[0]), tk[1]);
            count[e.prio]++;
            ori[oriPos++] = e;
            numbs--;
        }

        int i = 1;
        for (i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];

        }

        int pos0 = 0;
        for (int j = 0; j < ori.length; j++) {
            if (ori[j].prio == 0) {
                helper[pos0] = ori[j];
                pos0++;
            } else {
                helper[count[ori[j].prio - 1]++] = ori[j];
                
            }
        }
        int x =0;
        for(x =0 ; x< helper.length-1;x++){
            bw.write(helper[x].word+" ");
        }
        bw.write(helper[x].word+"\n");
        bw.flush();
    }

    public static class Element {

        String word;
        int prio;

        Element(int p, String w) {
            word = w;
            prio = p;
        }
    }
}
