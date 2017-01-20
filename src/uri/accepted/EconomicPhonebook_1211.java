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
public class EconomicPhonebook_1211 {

    static ArrayChar[] testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        while (input != null && !input.equals("")) {

            int numbs = Integer.valueOf(input);

            if (numbs != 0) {
                testCase = new ArrayChar[numbs];
                int pos = 0;
                while (numbs != 0) {
                    char[] numbArray = br.readLine().toCharArray();
                    testCase[pos] = new ArrayChar(numbArray);
                    pos++;
                    numbs--;
                }
                ArrayChar.quickSort(testCase);

                int saved = economicPhoneBook(testCase);
                bw.write(saved + "\n");
            }

            input = br.readLine();

        }
        bw.flush();

    }

    public static int economicPhoneBook(ArrayChar[] numb) {
        ArrayChar prev = numb[0];
        int count = 0;
        for (int i = 1; i < numb.length; i++) {
            ArrayChar comp = numb[i];
            count += compareNumbs(prev, comp);
            prev = comp;
        }
        return count;
    }

    private static int compareNumbs(ArrayChar prev, ArrayChar comp) {
        int count = 0;
        for (int i = 0; i < prev.array.length; i++) {
            if (prev.array[i] == comp.array[i]) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    static class ArrayChar {

        char[] array;

        public ArrayChar(char[] a) {
            array = a;
        }

        private int compare(ArrayChar c) {
            if (array.length != c.array.length) {
                return -1;
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] > c.array[i]) {
                    return 1;
                } else if (array[i] < c.array[i]) {
                    return -1;
                }

            }
            return 0;
        }

        public static ArrayChar[] quickSort(ArrayChar[] array) {

            ArrayChar[] c = array;
            int wall = 0;
            int pivot = c.length - 1;

            quickSort(wall, pivot, c);
            return c;
        }

        protected static void quickSort(int wall, int posPivot, ArrayChar[] c) {
            int start = wall;
            int end = posPivot;
            ArrayChar tmp, current;

            if (wall == posPivot || wall > posPivot) {
                return;
            }

            for (int i = wall; i < posPivot; i++) {
                current = c[i];
                if (current.compare(c[posPivot]) == 1) {
                    tmp = c[wall];
                    c[wall] = current;
                    c[i] = tmp;
                    wall++;
                }
            }

            tmp = c[wall];
            c[wall] = c[posPivot];
            c[posPivot] = tmp;

            quickSort(start, wall - 1, c);
            quickSort(wall + 1, end, c);

        }

    }
}
