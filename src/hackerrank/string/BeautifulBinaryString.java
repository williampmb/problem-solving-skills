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
public class BeautifulBinaryString {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int lenght = s.nextInt();
        String line = s.next();
        int steps = 0;
        for(int i =0; i < lenght;i++){
            if(line.charAt(i)=='0'){
                if(i < lenght-2 && line.charAt(i+1) == '1' && line.charAt(i+2) == '0' ){
                    steps++;
                    i+=2;
                }
            }
        }
        System.out.println(steps);
    }
}
