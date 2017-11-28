/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri.accepted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 *
 * @author willi
 */
public class ErasingAndWining_1084 {

    public static void main(String[] args) throws IOException {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        //BufferedReader br = new BufferedReader(new FileReader("src/forfun/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        while (s1 != null && !s1.equals("")) {
            String[] tk = s1.split(" ");
            int size = Integer.parseInt(tk[0]);
            int erase = Integer.parseInt(tk[1]);
            if (size == 0 && erase == 0) {
                break;
            }
            int remain = size - erase;
            String numb = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < size; i++) {
                char current = numb.charAt(i);
                while (!stack.isEmpty() && erase > 0 && current > stack.peek()) {
                    stack.pop();
                    erase--;
                }
                if (stack.size() < remain) {
                    stack.push(current);
                }
            }

            for (char c : stack) {
                bw.write(c);
            }
            bw.write("\n");
            bw.flush();

            s1 = br.readLine();
        }

        bw.close();
        br.close();

    }
}
