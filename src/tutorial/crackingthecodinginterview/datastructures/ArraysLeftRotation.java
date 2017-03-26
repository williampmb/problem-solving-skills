package tutorial.crackingthecodinginterview.datastructures;


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
public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = s.nextInt();
        int rotation = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }
        array = leftRotation(array, rotation);

        for (int i = 0; i < n; i++) {
            sb.append(array[i] + " ");
        }
        System.out.println(sb.toString());
    }

    private static int[] leftRotation(int[] a, int r) {
        if (a == null || a.length == 1 || a.length == r) {
            return a;
        }
        if(r>a.length){
            r-=a.length;
        }
        int mod = a.length%r==0?r-1:0;
        while(mod != -1){
            int ini = mod, store = a[ini], cur = ini;
            int next = getPosInArray(ini + r, a.length);
            while(ini != next){
                a[cur] = a[next];
                cur = next;
                next = getPosInArray(next + r, a.length);
            }
            a[cur] = store;
            mod--;
        }
        
        return a;
    }

    private static int getPosInArray(int pos, int size) {
        int inArray = size> pos?pos:pos%size;
        return inArray;
    }
}
