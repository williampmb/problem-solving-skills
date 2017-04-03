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
public class HackerRankIsAString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (test != 0) {
            String word = s.next();
            String isHR = isHackerRank(word);
            sb.append(isHR+"\n");
            test--;
        }
        System.out.print(sb.toString());
    }

    private static String isHackerRank(String word) {
        char[] hr = "hackerrank".toCharArray();
        int pos = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)==hr[pos]){
                pos++;
            }
            if(pos >= hr.length){
                return "YES";
            }
        }
        return "NO";
    }
}
