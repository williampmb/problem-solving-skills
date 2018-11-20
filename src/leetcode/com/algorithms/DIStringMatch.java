/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author William Barbosa
 */
public class DIStringMatch {
    
    public static void main(String[] args){
        DIStringMatch di  = new DIStringMatch();
        
        int[] diStringMatch = di.diStringMatch("IDID");
        System.out.println(diStringMatch);
    }
    
    public int[] diStringMatch(String S) {
        int end = S.length(), start =0;
        int[] ans = new int[S.length()+1];
        
        char c = S.charAt(0);
        if(c == 'D'){
            ans[0] = end--;
            ans[1] = start++;
        }else{
            ans[1] = end--;
            ans[0] = start++;
        }
        int cur = 1;
        for(int i =1;i < S.length();i++){
            c = S.charAt(i);
            if(c == 'D'){
                if(ans[cur]<end){
                    ans[cur+1]= ans[cur];
                    ans[cur] = end--;
                }else{
                    ans[cur+1] = end--;
                }
                
            }else{
                if(ans[cur]>start){
                    ans[cur+1]= ans[cur];
                    ans[cur] = start++;
                }else{
                    ans[cur+1] = start++;
                }
                
            }
            cur++;
        }
        
        return ans;
    }
    
    
    //Same algorithm but better looking
     public int[] diStringMatch2(String S) {
        int size = S.length(),start=0,end=S.length();
        int[] ans = new int[size+1];
        for(int i = 0; i < size;i++){
            char c = S.charAt(i);
            if(c == 'D'){
                ans[i] = end--;
            }else{
                ans[i] = start++;
            }
        }
        ans[size]=end;
        return ans;
     }
}
