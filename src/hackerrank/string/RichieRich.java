package hackerrank.string;


import java.util.ArrayList;
import java.util.List;
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
public class RichieRich {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numbDigits = s.nextInt();
        int modifiedDigits = s.nextInt();
        String number = s.next();

        String newNumber = transformPalindrome(number, modifiedDigits);
        System.out.println(newNumber);
    }

    private static String transformPalindrome(String number, int modifiedDigits) {
        int length = number.length();
        char[] palindrome = new char[length];
        StringBuilder sb = new StringBuilder();
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < length / 2; i++) {
            char left = number.charAt(i);
            char right = number.charAt(length - 1 - i);
            if (left != right) {
                if (left > right) {
                    palindrome[i] = left;
                    palindrome[length - 1 - i] = left;
                } else {
                    palindrome[i] = right;
                    palindrome[length - 1 - i] = right;
                }
                modifiedDigits--;
                pos.add(i);
            } else {
                palindrome[i] = left;
                palindrome[length - 1 - i] = right;
            }
        }
        if( palindrome.length%2 ==1){
            palindrome[palindrome.length / 2] = number.charAt(palindrome.length / 2);
        }

        if (modifiedDigits < 0) {
            return "-1";
        } else if (modifiedDigits > 0) {
            palindrome = maximize(palindrome, modifiedDigits, pos);
        }
        for (char c : palindrome) {
            sb.append(c);
        }
        return sb.toString();

    }

    private static char[] maximize(char[] palindrome, int modifiedDigits, List<Integer> pos) {

        for (int i = 0; i < palindrome.length / 2; i++) {
            if (palindrome[i] != '9' && modifiedDigits > 0) {
                boolean remove = pos.remove(new Integer(i));
                if (remove) {
                    modifiedDigits--;
                    palindrome[i] = '9';
                    palindrome[palindrome.length - 1 - i] = '9';
                } else if (modifiedDigits > 1) {
                    modifiedDigits -= 2;
                    palindrome[i] = '9';
                    palindrome[palindrome.length - 1 - i] = '9';
                }
              
            }
        }
        
        if(modifiedDigits >0 && palindrome.length%2 ==1){
            palindrome[palindrome.length / 2] = '9';
        }
        return palindrome;

    }

}
