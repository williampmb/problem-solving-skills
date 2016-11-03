package uri.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class ShortAttendance_1277 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder result = new StringBuilder();

        input = br.readLine();
        int tests, qtStudents, p, a, count;
        double taxAtt;
        String[] name;

        tests = Integer.valueOf(input);

        while (tests != 0) {

            input = br.readLine();
            qtStudents = Integer.valueOf(input);
            input = br.readLine();
            name = input.split(" ");
            input = br.readLine();
            String[] attendance = input.split(" ");
            count = 0;
            for (int i = 0; i < attendance.length; i++) {
                p = 0;
                a = 0;

                for (char day : attendance[i].toCharArray()) {
                    if (((int) 'P') == ((int) day)) {
                        p++;
                    } else if (((int) 'A') == ((int) day)) {
                        a++;
                    }
                }
                taxAtt = (double) p / ((double) (a + p));
                if (taxAtt < 0.75) {
                    count++;
                    result.append(name[i]);
                    result.append(" ");

                }

            }
            if (count > 0) {
                result.deleteCharAt(result.toString().length() - 1);
            }
            result.append("\n");
            tests--;
        }

        bw.write(result.toString());
        bw.flush();
    }
}
