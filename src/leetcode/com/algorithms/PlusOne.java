package leetcode.com.algorithms;

public class PlusOne {

    public static void main(String[] args){

        int[] ans = plusOne(new int[]{1,2,9});
        System.out.print(ans.toString());
    }
    
    public static int[] plusOne(int[] digits) {
        
        int carry = 1;
        for(int i = digits.length -1 ; i >=0 ; i--){
            digits[i] = (digits[i] + carry)%10;
            if(digits[i]==0){
                carry = 1;
            }else{
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i = 1 ; i < ans.length ; i++ ){
                ans[i] = digits[i-1];
            }
            return ans;
        }
        return digits;
    }
}
