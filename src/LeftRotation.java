
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
public class LeftRotation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int rot = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }
        array = leftRotation(array, rot);
        
        for(int i : array){
            System.out.print(i+" ");
        }
    }

    private static int[] leftRotation(int[] a, int rot) {
        int size = a.length;
        if (size % rot == 0) {
            a = jumping(a, rot, rot);
        } else if (rot % 2 == 0 && size % 2 == 0) {
            int range = rot - (size % rot);
            a = jumping(a, rot, range);
        } else {
            a = jumping(a, rot, 1);
        }
        return a;
    }

    private static int[] jumping(int[] a, int rot, int range) {
        int size = a.length;
        for (int i = 0; i < range; i++) {
            int cur = i;
            int val = a[i];
            int next = (cur + rot) % size;
            while (next != i) {
                a[cur] = a[next];
                cur = next;
                next = (cur + rot) % size;
            }
            a[cur] = val;
        }
        return a;
    }
}
