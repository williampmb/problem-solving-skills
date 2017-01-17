package uri.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 *
 *
 *
 *
 * Considering the input of non-negative integer values​​, sort these numbers
 * ​​according to the following criteria: First the even in ascending order
 * followed by the odd in descending order. Input The first line of input
 * contains a positive integer number N (1 < N < 105). This is the number of
 * following input lines. The next N lines contain, each one, a integer
 * non-negative number. Print all numbers according to the explanation presented
 * above. Each number must be printed in one line as shown below.
 *
 *
 */
public class EvenAndOdd_1259 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        
        int n = Integer.valueOf(input);
        List<Integer> even = new ArrayList<Integer>();
        List<Integer> odd = new ArrayList<Integer>();

        while (n !=0) {
            
            int insert = Integer.valueOf(br.readLine());
            if (insert % 2 == 0) {
                even.add(insert);
            }else{
                odd.add(insert);
            }
            n--;
        }
        
        Collections.sort(even);
        Collections.sort(odd, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        
        
        for(int e : even){
            bw.write(e + "\n");
        }
        
        for(int o : odd){
            bw.write(o + "\n");
        }
        bw.flush();
    }

}
