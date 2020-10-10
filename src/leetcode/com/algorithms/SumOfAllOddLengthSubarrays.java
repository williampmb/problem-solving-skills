package leetcode.com.algorithms;

public class SumOfAllOddLengthSubarrays{

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3};
        SumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr);
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int pos =0, totalSum =0;
        
        for(int i=1; i <= arr.length;i+=2){
            totalSum += sumWindow(arr,i);    
        }
        
        return totalSum;
    }
    
    public static int sumWindow(int[] arr, int w){
        int curSum = 0;
        int totalSum =0;
        
        for(int i =0 ; i < arr.length; i++){
            if(i +1< w){
                curSum += arr[i];
            }else if(i+1==w){
                curSum += arr[i];
                totalSum +=curSum;
            } else{
                curSum += arr[i];
                curSum -= arr[i-w];
                totalSum +=curSum;
            }
            
        }
        return totalSum;
    }
}
