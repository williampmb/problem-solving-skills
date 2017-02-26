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
public class SherlockAndArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        
        while(testCase != 0){
            int n = Integer.parseInt(br.readLine());
            String arrayLine = br.readLine();
            int[] array = stringToArray(arrayLine);
            String hasSum = sumLeftEqualsRight(array);
            bw.write(hasSum+ "\n");
            testCase--;
        }
        bw.flush();
        
    }

    private static int[] stringToArray(String arrayLine) {
        String[] tk = arrayLine.split(" ");
        int[] array = new int[tk.length];
        int i =0;
        for(String num : tk){
            array[i]=Integer.parseInt(num);
            i++;
        }
        return array;
    }

    private static String sumLeftEqualsRight(int[] array) {
        if(array.length ==2 ){
            return "NO";
        }
        if(array.length <3 ){
            return "YES";
        }
        int sumLeft = array[0], sumRight =0;
        for(int j=2; j<array.length;j++){
            sumRight+=array[j];
        }
        for(int i=1;i<array.length-1;i++){
            if(sumLeft == sumRight){
                return "YES";
            }
            sumLeft+=array[i];
            sumRight-=array[i+1];
        }
        return "NO";
    }
}
