/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingbat.com;

/**
 *
 * @author willi
 */
public class StringSplosion {
    public static void main(String[] args){
        String input = "Code";
        String r = stringSplosion(input);
        System.out.println(r);
    }

    private static String stringSplosion(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= input.length(); i++){
            sb.append(input.substring(0, i));
        }
        return sb.toString();
    }
}
