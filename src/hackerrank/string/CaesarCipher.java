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
public class CaesarCipher {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        String word = s.nextLine();
        int k = s.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < size ; i++ ){
            char c = word.charAt(i);
            if((c > 64 && c < 91) ){
                c -=65;
                c+=k;
                c%=26;
                c+=65;
            }else if( (c > 96 && c<123)){
                c -=97;
                c+=k;
                c%=26;
                c+=97;
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
