package hackerrank.implentation;


import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class DesignerPDFViewer {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] h = new int[26];
        int maxh = 0;
        for(int i = 0; i < h.length; i++){
            h[i] = s.nextInt();
        }
        String word = s.next();
        for(char c : word.toCharArray()){
            if(c >96 && c < 123 && maxh < h[c-97]){
                maxh =h[c-97];
            }
        }
        System.out.println(maxh*word.length());
    }
}
