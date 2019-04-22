package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public static void main(String[] args){

    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character>[] bucket = new ArrayList[s.length()+1];
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Iterator<Character> it = map.keySet().iterator();
        while(it.hasNext()){
            Character next = it.next();
            Integer freq = map.get(next);
            if(bucket[freq]== null){
                bucket[freq] = new ArrayList<>();
            }
            int index = freq;
            while(freq >0){
                bucket[index].add(next);
                freq--;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = bucket.length-1 ; i >0; i--){
            if(bucket[i]==null)continue;
            for(char c : bucket[i]){
                ans.append(c);
            }
        }

        return ans.toString();
    }
}