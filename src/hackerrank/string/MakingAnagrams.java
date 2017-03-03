package hackerrank.string;


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
public class MakingAnagrams {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        int[] arrayA = new int[26];
        int[] arrayB = new int[26];
        for(int i =0 ; i< a.length(); i++){
            arrayA[a.charAt(i)-97]++;
        }
        for(int i =0 ; i< b.length(); i++){
            arrayB[b.charAt(i)-97]++;
        }
        
        int delete =0;
        for(int i = 0 ; i < 26; i ++){
            delete += Math.abs(arrayA[i] - arrayB[i]);
        }
        System.out.println(delete);
    }
}
