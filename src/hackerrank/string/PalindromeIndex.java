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
public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int test = s.nextInt();
        while (test != 0) {
            String palindrome = s.next();
            boolean removed = false;
            for (int i = 0; i < palindrome.length(); i++) {
                int endIndex = palindrome.length() - i - 1;

                if (palindrome.charAt(i) != palindrome.charAt(endIndex)) {
                    removed = true;
                    String prefix = palindrome.substring(0, i);
                    String sufix = palindrome.substring(i + 1, palindrome.length());
                    boolean pal = isPalindrome(prefix + sufix);
                    if (pal) {
                        sb.append(i + "\n");
                        break;
                    }
                    prefix = palindrome.substring(0, endIndex);
                    sufix = palindrome.substring(endIndex + 1, palindrome.length());
                    pal = isPalindrome(prefix + sufix);
                    if (pal) {
                        sb.append(endIndex + "\n");
                        break;
                    }
                    sb.append("-1" + "\n");
                    break;
                }
            }
            if (!removed) {
                sb.append("-1" + "\n");
            }
            test--;
        }
        System.out.print(sb.toString());
    }

    private static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
