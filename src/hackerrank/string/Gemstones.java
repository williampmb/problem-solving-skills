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
public class Gemstones {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rocks = s.nextInt();
        int[] gemelements = new int[rocks];
        int count2 = 0;
        while (rocks != count2) {
            String rock = s.next();
            for (int i = 0; i < rock.length(); i++) {
                char element = rock.charAt(i);
                gemelements[count2] = setBitToOne(gemelements[count2], element - 97);
            }
            count2++;
        }
        int count = 0;

        for (int j = 0; j < 26; j++) {
            int gem = getGem(gemelements, j);
            if(gem != -1){
                count++;
            }
        }

        System.out.println(count);
    }

    private static int setBitToOne(int gemelement, int pos) {
        return gemelement | (1 << pos);
    }

    private static int getGem(int[] gemelements, int j) {
        int gem1 = (gemelements[0] & 1 << j);
        for (int i = 0; i < gemelements.length; i++) {
            if((gem1 & (gemelements[i] & 1 << j))==0){
                return -1;
            }
        }
        return j+97;
    }
}
