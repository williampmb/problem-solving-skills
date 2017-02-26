package hackerrank.constructivealgorithms;


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
public class FlippingTheMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/hackrank/constructivealgorithms/FlippingTheMatrixInput.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int queries = Integer.parseInt(br.readLine());

        while (queries != 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = readMatrix(n, br);
            int sum = flippingTheMatrix(matrix);
            bw.write(sum + "\n");
            queries--;
        }

        bw.flush();
    }

    public static int flippingTheMatrix(int[][] a) {
        if (a == null || a.length != a[0].length || a.length % 2 != 0) {
            return 0;
        }
        int lastIndex =  a.length -1;
        int row = a.length;
        int col = row;

        for (int i = 0; i < row/2; i++) {
            for (int j = 0; j < col/2; j++) {
                int quadrant = findGreaterValue(i, j, a);
                if (quadrant == 2) {
                    a = flipCol(j,a);
                    a = flipCol(lastIndex - j,a);
                    a = flipRow(lastIndex - i, a);
                    a = a = flipCol(j,a);
                } else if (quadrant == 3) {
                    a = flipRow(i, a);
                    a = flipRow(lastIndex - i, a);
                    a = flipCol(lastIndex - j, a);
                    a = flipRow(i,a);
                } else if (quadrant == 4) {
                    a = flipRow(i,a);
                    a = flipCol(lastIndex -j, a);
                    a = flipRow(i, a);
                }
            }
        }

        int sum = maxSumNxN(a);
        return sum;
    }

    private static int findGreaterValue(int i, int j, int[][] a) {
        int size = a.length - 1, max = a[i][j], quadrant = 1;

        if (max < a[i][size - j]) {
            quadrant = 2;
            max = a[i][size - j];
        }
        if (max < a[size - i][j]) {
            quadrant = 3;
            max = a[size - i][j];
        }
        if (max < a[size - i][size - j]) {
            quadrant = 4;
        }

        return quadrant;
    }
    
    private static int[][] flipRow(int i, int[][] a) {
        for (int j = 0; j < a.length / 2; j++) {
            int tmp = a[i][j];
            a[i][j] = a[i][a.length - 1 - j];
            a[i][a.length - 1 - j] = tmp;
        }
        return a;
    }

    private static int[][] flipCol(int j, int[][] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i][j];
            a[i][j] = a[a.length - 1 - i][j];
            a[a.length - 1 - i][j] = tmp;
        }
        return a;
    }

    private static int maxSumNxN(int[][] a) {
        int row = a.length / 2;
        int col = row;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(int n, BufferedReader br) throws IOException {
        int n2 = n * 2;
        int[][] matrix = new int[n2][n2];

        for (int i = 0; i < n2; i++) {
            String row = br.readLine();
            String[] cols = row.split(" ");
            for (int j = 0; j < cols.length; j++) {
                matrix[i][j] = Integer.parseInt(cols[j]);
            }
        }
        return matrix;
    }
}
