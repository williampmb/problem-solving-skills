/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class ComplexNumberMultipication {
    public static void main(String[] args){
        ComplexNumberMultipication c = new ComplexNumberMultipication();
        String complex = c.complexNumberMultiply("1+-1i", "1+-1i");
        System.out.println(complex);
        
    }
    
   public String complexNumberMultiply(String a, String b) {
       String[] tokA = a.split("\\+");
       String[] tokB = b.split("\\+");
       
       int realA = Integer.parseInt(tokA[0]);
       int complexA = Integer.parseInt(tokA[1].replace("i", ""));
       int realB = Integer.parseInt(tokB[0]);
       int complexB= Integer.parseInt(tokB[1].replace("i", ""));
       
       int real = realA*realB + (complexA*complexB*-1);
       int complex = realA*complexB + realB*complexA;
       String result = real +"+"+complex+"i";
       return result;
       
    } 
}
