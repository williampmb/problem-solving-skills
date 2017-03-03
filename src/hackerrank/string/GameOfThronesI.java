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
public class GameOfThronesI {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        int[] letters = new int[26];
        for(char c: word.toCharArray()){
            letters[c-97]++;
        }
        boolean odd = false;
        String palindrome = "YES";
        for(int letter : letters){
            if(letter%2 !=0){
                if(odd){
                    palindrome = "NO";
                    break;
                }
                odd= true;
            }
        }
        System.out.println(palindrome);
    }
}
