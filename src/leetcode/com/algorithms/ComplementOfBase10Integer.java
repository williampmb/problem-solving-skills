package leetcode.com.algorithms;

public class ComplementOfBase10Integer{
    public int bitwiseComplement(int N) {
        int ans =0, pos=0, one = 1;
        if(N ==0) return 1;
        while(N>0){
            int set = N & one;
            if(set != 1){
                ans = setBit(ans,pos);
            }
            pos++;
            N=N>>1;
        }
        return ans;
    }
    
    public int setBit(int ans, int pos){
        return ans | (1<<pos);
    }
} 