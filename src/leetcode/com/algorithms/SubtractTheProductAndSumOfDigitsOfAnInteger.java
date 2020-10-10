package leetcode.com.algorithms;

public class SubtractTheProductAndSumOfDigitsOfAnInteger{

    public static int subtractProductAndSum(int n) {
        int sum =0, prod=1;
        while(n>0){
            int dig = n%10;
            n/=10;
            sum+=dig;
            prod*=dig;
        }
        return prod-sum;
    }
}