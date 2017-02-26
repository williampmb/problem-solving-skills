package hackerrank.search;


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
public class MissingNumbers {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = new int[10000];
        int sizeA = Integer.valueOf(br.readLine());
        String[] arrayA = br.readLine().split(" ");
        
        int sizeb = Integer.valueOf(br.readLine());
        String[] arrayB = br.readLine().split(" ");
        
        for(int i = 0; i< sizeA ; i++){
            int numb = Integer.parseInt(arrayA[i]);
            array[getIndex(numb)]++;
            int numb2 = Integer.parseInt(arrayB[i]);
            array[getIndex(numb2)]--;
        }
        
        for(int j = sizeA; j< sizeb ; j++){
            int numb = Integer.parseInt(arrayB[j]);
            array[getIndex(numb)]--;
        }
        
        for(int m = 0; m<array.length;m++){
            if(array[m]<0){
                bw.write(getNumb(m)+ " ");
            }
        }
        bw.write("\n");
        bw.flush();
        
        
    }

    private static int getIndex(int numb) {
        return numb-1;
    }
    private static int getNumb(int index) {
        return index+1;
    }
}
