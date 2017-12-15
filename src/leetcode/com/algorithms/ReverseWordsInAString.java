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
public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        String reverseWords = r.reverseWords("    a   b  ");
        //String reverseWords = r.reverseWords("  hey grandman, look at me  ");
        System.out.println(reverseWords);

    }

    public String reverseWords(String s) {
        int size = s.length();
        int start = 0, endPhrase = size - 1;
        while (start < size && s.charAt(start) == ' ') {
            start++;
        }

        while (endPhrase >= 0 && s.charAt(endPhrase) == ' ') {
            endPhrase--;
        }
        if (start > endPhrase) {
            return "";
        }
        String formated = s.substring(start, endPhrase + 1);
        size = formated.length();
        char[] array = formated.toCharArray();

        for (int i = 0; i < size / 2; i++) {
            char tmp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = tmp;
        }

        int wordStartsAt = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == ' ' || i == size - 1) {
                int end = i == size - 1 ? i + 1 : i;
                int count = 0;
                for (int j = wordStartsAt; j < (wordStartsAt + end) / 2; j++) {
                    char tmp = array[j];
                    array[j] = array[end - 1 - count];
                    array[end - 1 - count] = tmp;
                    count++;
                }
                wordStartsAt = i + 1;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == ' ' && array[i] == ' ') {

            } else {
                result.append(array[i]);
            }
        }

        return result.toString();
    }
}
