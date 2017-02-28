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
public class FunnyString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int test = s.nextInt();
        s.nextLine();
        while (test != 0) {
            String word = s.nextLine();
            String funny = isFunny(word);
            sb.append(funny + "\n");
            test--;
        }
        System.out.print(sb.toString());

    }

    private static String isFunny(String word) {
        int length = word.length() ;

        char[] array = word.toCharArray();
        for (int i = 0; i < length/2; i ++) {
            
            if (Math.abs(array[i] - array[i + 1]) != Math.abs(array[length - i - 1] - array[length - i - 1 - 1])) {
                return "Not Funny";
            }
        }
        return "Funny";
    }
}
