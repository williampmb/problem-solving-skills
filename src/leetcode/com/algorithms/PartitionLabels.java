/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        List<Integer> labels = p.partitionLabels("eaaaabaaec");
        for (int l : labels) {
            System.out.println(l);
        }
    }

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<Integer>();
        }
        int[][] db = new int[26][2];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < db.length; i++) {
            db[i][0] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);
            if (db[letter - 'a'][0] == -1) {
                db[letter - 'a'][0] = i;
            } else {
                db[letter - 'a'][1] = i;
            }
        }

        //start = db[S.charAT(0)-'a'][0] =0
        int start = 0, end = 0;

        while (start < S.length()) {
            end = db[S.charAt(start) - 'a'][1];
           
            if (end != 0) {
                for (int i = 0; i < 26; i++) {
                    if (db[i][0] > start && db[i][0] < end && db[i][1] > end) {
                        end = db[i][1];
                        i = -1;
                    }
                }
                 ans.add(end - start + 1);
                 start = end + 1;
            }else{
                //if the letter appears just once, its end will be 0.
                ans.add(1);
                start ++;
            }

           
        }
        return ans;
    }
    
    //author: @samuelytji. Same idea above but simpler. It doesn't need to keep
    // track of the start of a char.
    public List<Integer> partitionLabels2(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
