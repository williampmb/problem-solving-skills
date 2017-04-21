package hackerrank.arrays;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willi
 */
public class Array2dDs {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int[][] array = new int[6][6];

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = s.nextInt();
            }
        }

        int sum = maxHourGlass(array);
        
        System.out.println(sum);
    }

    private static int maxHourGlass(int[][] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4; j++) {
                sum = addGlasses(array,i,j);
                if(sum > max) max = sum;
            }
        }
        return max;
    }

    private static int addGlasses(int[][] array, int i, int j) {
        int sum= 0;
        sum+= array[i][j] + array[i][j+1] + array[i][j+2];
        sum+= array[i+1][j+1];
        sum+= array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
        return sum;
    }
}
