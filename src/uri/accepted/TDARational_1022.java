package uri.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
public class TDARational_1022 {

    public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new FileReader("src//input_1141.txt"));
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int input = Integer.valueOf(br.readLine());

        while (input != 0) {
            String equation = br.readLine();

            StringBuilder first = new StringBuilder();
            StringBuilder second = new StringBuilder();
            String operator = "";

            boolean div1 = false;
            boolean div2 = false;
            boolean op = false;
            boolean firstOp = true;

            for (int i = 0; i < equation.length(); i++) {
                char simbol = equation.charAt(i);
                if(simbol == ' ') continue;
                if (!div1) {
                    if (simbol == '/') {
                        div1 = true;
                    }
                    first.append(simbol);
                } else if (!op) {
                    if (!firstOp && (simbol == '+' || simbol == '-' || simbol == '*' || simbol == '/')) {
                        operator = simbol + "";
                        firstOp = true;
                        op = true;
                    } else {
                        firstOp = false;
                        first.append(simbol);
                    }
                } else if (!div2) {
                    if (simbol == '/') {
                        div2 = true;
                    }
                    second.append(simbol);
                } else {
                    second.append(simbol);
                }
            }

            answer.append(breakStringIntoNumbers(first.toString(), second.toString(), operator) + "\n");

            input--;
        }

        bw.write(answer.toString());
        bw.flush();

    }

    public static StringBuilder tdaRational(int n1, int d1, int n2, int d2, String operator) {
        StringBuilder partial = new StringBuilder();
        switch (operator) {
            case "+":
                int n3 = (n1 * d2 + n2 * d1);
                int d3 = d1 * d2;
                partial.append(n3 + "/" + d3 + " = ");
                int[] frac = simplify(n3, d3);
                partial.append(frac[0] + "/" + frac[1]);
                break;
            case "-":
                int n4 = (n1 * d2 - n2 * d1);
                int d4 = d1 * d2;
                partial.append(n4 + "/" + d4 + " = ");
                int[] frac1 = simplify(n4, d4);
                partial.append(frac1[0] + "/" + frac1[1]);
                break;
            case "*":
                int n5 = n1 * n2;
                int d5 = d1 * d2;
                partial.append(n5 + "/" + d5 + " = ");
                int[] frac2 = simplify(n5, d5);
                partial.append(frac2[0] + "/" + frac2[1]);
                break;
            case "/":
                int n6 = n1 * d2;
                int d6 = n2 * d1;
                partial.append(n6 + "/" + d6 + " = ");
                int[] frac3 = simplify(n6, d6);
                partial.append(frac3[0] + "/" + frac3[1]);
                break;
            default:
        }
        return partial;
    }

    private static int[] simplify(int n, int d) {
        if (n == 0 || d == 0) {
            return new int[]{n, d};
        }
        if (Math.abs(n) == 1 || Math.abs(d) == 1) {
            return new int[]{n, d};
        }

        int smallest = Math.abs(n) > Math.abs(d) ? d : n;
        int simplify = Math.abs(smallest);
        while (simplify > 1) {
            if (n % simplify == 0 && d % simplify == 0) {
                n /= simplify;
                d /= simplify;
            }
            simplify--;
        }
        int[] res = {n, d};
        return res;
    }

    private static StringBuilder breakStringIntoNumbers(String numerator, String denominator, String operation) {
        int n1, n2, d1, d2;
        String[] num1 = numerator.split("/");
        n1 = Integer.valueOf(num1[0]);
        d1 = Integer.valueOf(num1[1]);

        String[] denom2 = denominator.split("/");
        n2 = Integer.valueOf(denom2[0]);
        d2 = Integer.valueOf(denom2[1]);
        return tdaRational(n1, d1, n2, d2, operation);
    }
}
