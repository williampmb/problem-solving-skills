package hackrank.string;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
public class TwoStrings {

    //Big-O: Time: t (test times) * twoString = O(t (n+m))
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(s.nextLine());
        while (test != 0) {
            String l1 = s.nextLine();
            String l2 = s.nextLine();
            String isSubstring = twoString(l1, l2);
            bw.write(isSubstring + "\n");
            test--;
        }
        bw.flush();
    }

    //Big-O: Time: n (l1.length) + m(l2.length) = O(n+m)
    //Space O(1)
    private static String twoString(String l1, String l2) {
        int[] db = new int[26];
        for(int i =0 ;i < l1.length(); i++){
           db[l1.charAt(i)-97]++;
        }
        for(int j =0 ;j < l2.length(); j++){
            if(db[l2.charAt(j)-97]>0) return "YES";
        }
        return "NO";
    }
}
