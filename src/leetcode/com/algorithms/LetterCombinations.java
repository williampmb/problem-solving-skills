/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author willi
 */
public class LetterCombinations {

    static Map<Character, String> db = null;
    
    public static void main(String[] args){
        List<String> letterCombinations = letterCombinations("12315");
        for(String s : letterCombinations) System.out.println(s);
    }

    // we should use StringBuilder insted of String to build our Strings
    // We should put in another method and when we calculate all the possibilites
    // we create the last List of Strings to copy from StringBuilder variables.
    public static List<String> letterCombinations(String digits) {
        List<String> words = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return words;
        }
        String possibiles = recoverPossibleLetters(digits.charAt(0));

        List<String> partialWords = letterCombinations(digits.substring(1));
        if (possibiles == null) {
            return partialWords;
        }
        for (char c : possibiles.toCharArray()) {
            if(partialWords.isEmpty()){
                partialWords.add("");
            }
            for (String s : partialWords) {
                words.add(c + s);
            }
        }

        return words;
    }

    //It could be a formula to calculate where the '2' in ASCII corresponds to
    // the alphabet in ASCII 'a' = 97 and the next 2 letters. If the number is greater than 6
    // we should calculate base on 7 has 4 letters, 8 has 3 letters and 9 has 4
    // we would do some processing for each digit but it is not to expensive since
    // it is O(1) to calculate. In this case we are using extra data structure but
    // also we are using constant memory to store all values independently from input O(1) 
    public static String recoverPossibleLetters(Character c) {
        if (!Character.isDigit(c)) {
            return null;
        }

        if (db == null) {
            db = new Hashtable<Character, String>();
            db.put('2', "abc");
            db.put('3', "def");
            db.put('4', "ghi");
            db.put('5', "jkl");
            db.put('6', "mno");
            db.put('7', "pqrs");
            db.put('8', "tuv");
            db.put('9', "wxyz");
        }
        if (c == '1') {
            return null;
        } else if (c == '0') {
            return " ";
        }
        return db.get(c);
    }
}
