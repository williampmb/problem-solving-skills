package hackerrank.string;


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
public class AlternatingCharacters {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(s.nextLine());
        while (test != 0) {
            String line = s.nextLine();
            int deletions = formatLikeWanted(line);
            bw.write(deletions + "\n");
            test--;
        }
        bw.flush();
    }

    private static int formatLikeWanted(String line) {
        char lookAt = line.charAt(0);
        int delCount = 0;
        for (int i = 1; i < line.length(); i++) {
            if(lookAt == line.charAt(i)){
                delCount++;
            }else{
                lookAt = line.charAt(i);
            }
        }
        return delCount;
    }
}
