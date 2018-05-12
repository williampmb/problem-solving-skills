/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.microsoft.arraystrings;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author William Barbosa
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack();
        Map<Character, Character> addMap = new Hashtable<>();
        Map<Character, Character> remMap = new Hashtable<>();
        addMap.put('(', ')');
        addMap.put('{', '}');
        addMap.put('[', ']');
        remMap.put(')', '(');
        remMap.put('}', '{');
        remMap.put(']', '[');
        
        for (int i = 0; i < s.length(); i++) {
            char parenthese = s.charAt(i);
            
            if(addMap.get(parenthese) != null){
                parentheses.add(addMap.get(parenthese));
            }else if(remMap.get(parenthese) != null){
                if(parentheses.empty() || parentheses.pop() != parenthese){
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }
}
