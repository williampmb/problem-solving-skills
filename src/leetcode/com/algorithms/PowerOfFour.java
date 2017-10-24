/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class PowerOfFour {
    public static void main(String[] args){
        PowerOfFour p = new PowerOfFour();
        boolean powerOfFour2 = p.isPowerOfFour2(1073741824);
        System.out.println(Integer.toBinaryString(1073741824));
        System.out.println(Integer.toBinaryString((0xAAAAAAAA<<1)));
        System.out.println(powerOfFour2);
    }

    public boolean isPowerOfFour(int num) {
        //check if it is negative or it is not a power of two
        if(num < 1 || (num&(num-1))!=0) return false;
        if(num ==1) return true;
        int mask = 1;
        for(int i = 0 ; i <32;i++){
            if((mask&num)==1){
                if(i%2==0 && i >1){
                    if((num>>1)==0){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
            num>>=1;
        }
        return false;
    }
    
    /* 4 = 100   (pos = 2)
    * 16 = 10000  (pos = 4)
    * 64 = 1000000 (pos = 6)
    * every power of 4 it will have a bit 1 in an odd position. So if we can 
    * check if thre is any bit set 1 in a even position with this
    * (num & (0xAAAAAAAA<<1)) != 0). the number 0xAAAAAAAA<<1 
    * is 10101010101010101010101010101010
    */
    
    public boolean isPowerOfFour2(int num) {
        return (num ==1) ||(num > 3 && (num&(num-1)) == 0 && (num & (0xAAAAAAAA<<1)) != 0);
    }
}
