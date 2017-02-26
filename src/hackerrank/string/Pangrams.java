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
public class Pangrams {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        
        String result = isPangrams(line);
        
        System.out.println(result);
    }

    private static String isPangrams(String s) {
       if(s.length() < 26 || s == null) return "not pangram";
        
       int allletters = ~((~0)<<26);
       int db =0;
       
       for(char c : s.toCharArray()){
           db = setBit(c, db);
           if(db == allletters) return "pangram";
       }
       
       return "not pangram";
    }

    private static int setBit(char c, int db) {
        if(c >64 && c < 91){
            c-=65;
        }else if(c > 96 && c< 123){
            c-=97;
        }else{
            return db;
        }
        db |= 1<<c;
        
       return db;
    }
}
