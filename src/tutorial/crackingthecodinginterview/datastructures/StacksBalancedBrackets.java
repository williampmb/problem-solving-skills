package tutorial.crackingthecodinginterview.datastructures;


import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class StacksBalancedBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }

    private static boolean isBalanced(String expression) {
        Stack<Integer> s = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            int bracket = expression.charAt(i);
            if (bracket == '{' || bracket == '(' || bracket == '[') {
                s.push(bracket);
            } else {
                if(s.isEmpty()) return false;
                Integer pop = s.pop();
                if (bracket == '}') {
                    if (pop != '{') {
                        return false;
                    }
                } else if (bracket == ']') {
                    if (pop != '[') {
                        return false;
                    }
                } else if (bracket == ')') {
                    if (pop != '(') {
                        return false;
                    }
                }

            }
        }
        
        if(!s.isEmpty()) return false;
        
        return true;
    }
}
