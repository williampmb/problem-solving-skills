package tutorial.crackingthecodinginterview.datastructures;


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
public class StringMakingAnagrams {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        
        int del = deletionForAnagram(s1,  s2);
        System.out.println(del);
    }

    private static int deletionForAnagram(String s1, String s2) {
        int[] db = new int[26];
        db = countLetters(s1,1,db);
        db = countLetters(s2,-1,db);
        
        int sum =0;
        for(int i =0; i < 26; i++){
            sum += Math.abs(db[i]);
        }
        return sum;
    }

    private static int[] countLetters(String s, int weight, int[] db) {
        for(int i =0 ; i < s.length(); i++){
            int alg = s.charAt(i) -97;
            db[alg] += 1*weight;
        }
        return db;
    }
}
