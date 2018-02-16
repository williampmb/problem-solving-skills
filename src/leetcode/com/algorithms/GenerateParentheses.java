/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author William Barbosa
 */
public class GenerateParentheses {
    public static void main(String[] args){
        GenerateParentheses g = new GenerateParentheses();
        List<String> ans = g.generateParenthesis(3);
        
        for(String s : ans){
            System.out.println(s);
        }
    }

    List<String> ans = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        if (n > 0) {
            generateParenthesis(n, 0, 0, new StringBuilder());
        }
        return ans;
    }

    public void generateParenthesis(int n, int left, int right, StringBuilder sequence) {
        if (sequence.length() == 2*n) {
            ans.add(sequence.toString());
        }
        if (left < n) {
            generateParenthesis(n, left +1, right, new StringBuilder().append(sequence+"("));
        }

        if (left > right && right < n) {
            generateParenthesis(n, left, right+1, sequence.append(")"));
        }
    }
    
    //Iterative approach
    public List<String> generateParenthesis2(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            
            lists.add(list);
        }
        
        return lists.get(lists.size() - 1);
    }
    
}
