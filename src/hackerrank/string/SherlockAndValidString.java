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
public class SherlockAndValidString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int[] db = new int[26];
        for (int i = 0; i < line.length(); i++) {
            db[line.charAt(i) - 97]++;
        }

        String answer = hasValidString(db);
        System.out.println(answer);
    }

    private static String hasValidString(int[] hist) {
        int small = -1;
        int big = -1;
        int count = 0,sum=0;
        for (int i = 0; i < 26; i++) {
            if(hist[i] !=0){
                count++;
                sum+=hist[i];
                if(small == -1) small = hist[i];
                else if(hist[i]!= small && big == -1) big = hist[i];
                else if (hist[i] != small && hist[i] != big) return "NO";
            }
        }
        if(big == -1) return "YES";
        int aux = small;
        small = aux > big? big:aux;
        big = aux < big ? big:aux;
        if(small*count == sum || small*count +1== sum) return "YES";
        if(small == 1){
            if(big*(count-1) == sum-1) return "YES";
        }
        return "NO";
    }
}
