/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class CustomSortString {

    public static void main(String[] args) {
        CustomSortString c = new CustomSortString();
        String customSortString = c.customSortString("kqep", "pekeq");
        System.out.println(customSortString);
    }

    public String customSortString(String S, String T) {
        int[] db = new int[26];
        for (char c : T.toCharArray()) {
            db[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            while(db[c - 'a'] > 0) {
                db[c - 'a']--;
                sb.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (db[i] > 0) {
                sb.append((char) (i + 'a'));
                db[i]--;
            }
        }

        return sb.toString();

    }
}
