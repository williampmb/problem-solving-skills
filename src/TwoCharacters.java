
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
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
public class TwoCharacters {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String numb = s.nextLine();
        String line = s.nextLine();
        int size = twoCharacters(line);
        System.out.println(size);
    }
    

    private static int twoCharacters(String line) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<line.length();i++){
            char at = line.charAt(i);
            if(map.get(at)==null){
                map.put(at, 1);
            }else{
                map.put(at, map.get(at)+1);
            }
        }
        
        Set<Character> letters = map.keySet();
        Iterator<Character> it = letters.iterator();
        char[] let = new char[letters.size()];
        int pos = 0;
        while(it.hasNext()){
            Character next = it.next();
            let[pos] = next;
            pos++;
        }
        
        ArrayList<char[]> pairs = new ArrayList<>();
        for(int i =0; i<let.length;i++){
            for(int j =i+1; j<let.length;j++){
                char[] pair = {let[i],let[j]};
                pairs.add(pair);
            }
        }
        int max =0;
        for(char[] p : pairs){
            int value = validade(p,line);
            max = max>value? max:value;
        }
        
        return max;
    }

    private static int validade(char[] p, String line) {
        char c1 = p[0];
        char c2 = p[1];
        int size =0;
        boolean start = false;
        char must = '0';
        for(int i =0 ; i<line.length();i++){
            char at = line.charAt(i);
            if(start){
                if(at == c1 && must ==c2){
                    must = c1;
                    size++;
                }else if ( at == c2 && must == c1){
                    must = c2;
                    size++;
                }else if(at != c2 && at !=c1){
                    continue;
                }else{
                    return 0;
                }
            }else{
                if(at == c1 || at == c2){
                    start = true;
                    must = at;
                    size++;
                }
            }
        }
        return size;
    }
}
