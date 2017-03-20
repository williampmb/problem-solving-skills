package hackerrank.search;


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
public class HackerLandRadioTransmitters {
//TO FIX - EXAMPLE:   1 2 0 0 6 7 0 9 10 and range 2

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numbh = s.nextInt();
        int range = s.nextInt();
        int[] houses = new int[numbh];
        for (int i = 0; i < numbh; i++) {
            houses[i] = s.nextInt();
        }

        int qtRadio = countRadioTransmitters(houses, range);
        System.out.println(qtRadio);

    }

    private static int countRadioTransmitters(int[] houses, int range) {
        int max = 0;
        int r = 0;
        int qtRadio = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] > max) {
                max = houses[i];
            }
        }
        int[] city = new int[max];
        for (int i = 0; i < houses.length; i++) {
            city[houses[i] - 1] = houses[i];
        }
        for (int j = 0; j < max; j++) {
            if (r > 0) {
                r--;
            } else if (city[j] > 0) {
                r = 2 * range + 1;
                r--;
                for (int i = j + range; i >= j; i--) {
                    if (i < max && city[i] > 0) {
                        qtRadio++;
                        break;
                    }
                    r--;
                }

            }
        }
        return qtRadio;
    }

    static void printCity(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
