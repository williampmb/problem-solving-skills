package codility;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class MinNonOccurPositiveNumberInArray {
    //

    public static void main(String[] args) throws IOException {
       
    }

    public int solution(int[] A) {
        Set<Integer> map = new HashSet<>();
        int min = 1;
        for(int a : A){
            if(a<1) continue;
            map.add(a);
        }

        while(map.contains(min)){
            min++;
        }
        return min;
     
    }
}
