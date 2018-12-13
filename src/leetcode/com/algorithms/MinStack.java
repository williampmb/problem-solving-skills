/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Stack;

/**
 *
 * @author William Barbosa
 */
public class MinStack {
    
    public static void main(String[] args){
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024);
        s.push(512);
        
        s.pop();
                
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
    }
    
    Stack<Integer> stack, minStack;
     public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
        stack.push(x);
    }
    
    public void pop() {
        if(minStack.isEmpty()) return;
        if(minStack.peek().equals(stack.peek()))
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/*
["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
[[],        [512],[-1024],[-1024],[512],[],[],[],[],[],[]]
512  -1024  -1024  512
512  -1024  -1024
*/
