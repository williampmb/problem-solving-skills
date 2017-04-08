/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsoft.interviwer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author William
 */
public class AllPossibleNumbers {

    static Map<Character, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('a', "973");
        map.put('b', "954");
        map.put('c', "831");
        map.put('d', "411");
        map.put('e', "321");
        map.put('f', "161");

        String input = "abc";
        printAllPossibleNumbers(input);

    }

    private static void printAllPossibleNumbers(String input) {
        if (input == null && input.length() == 0) {
            return;
        }
        findoutNumbers("", input);
    }

    private static void findoutNumbers(String print, String pend) {
        if (pend.length() == 0) {
            if (print.length() > 0) {
                System.out.println(print);
            }
            return;
        }

        String pending = "";
        if (pend.length() > 1) {
            pending = pend.substring(1);
        }
        if (map.get(pend.charAt(0))!= null) {
            String numbers = map.get(pend.charAt(0));
            for(int i = 0 ; i < numbers.length();i++){
                char numb = numbers.charAt(i);
                findoutNumbers(print+numb, pending);
            }
        }else{
            findoutNumbers(print, pending);
        }
    }

}
