package leetcode.com.algorithms.I;

public class FirstBadVersion {
 /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public static void main(String[] args){
        int bad = firstBadVersion2(2);
        System.out.println(bad);
    }
    
    public static boolean isBadVersion(int version){
        //API CALL
        return version >= 2;
    }
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int bad = 1;
        while(start<end){
            bad = start + (end - start)/2;
            if(isBadVersion(bad)){
                end = bad;
            }else{
                start = bad+1;
            }
        }
        return bad;
    }

    public static int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }





    // 1, 2 ,3 , 4 ,5 ,6, 7 8
    /**
    n = 1+8/2 = 4 true
        end = 4
        n = 1+4/2 = 2 false
            start = 2
            n = 2+4/2 = 3 true
                end = 2
                n = 2+2/2 = 2
                if bad is bad? bad ? bad + 1; 
            
    */
}
