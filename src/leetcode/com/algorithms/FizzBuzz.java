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
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        if(n <=0) return ans;
        int count =1;
        while(count <=n){
            String cur = count+"";
            
            if(count % 5 ==0&& count % 3==0) cur = "FizzBuzz";
            else if(count % 3==0) cur = "Fizz";
            else if(count % 5==0) cur = "Buzz";
            
            ans.add(cur);
            count++;
        }
        return ans;
    }
}
