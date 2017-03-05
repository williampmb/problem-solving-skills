package hackerrank.bitmanipulatio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
public class FlippingBits {
   
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        
        StringBuilder sb = new StringBuilder();
        while(test != 0){
            BigInteger value = s.nextBigInteger();
            sb.append(Integer.toUnsignedString(value.not().intValue())+"\n");
            test--;
        }
        System.out.println(sb.toString());
    }
}
