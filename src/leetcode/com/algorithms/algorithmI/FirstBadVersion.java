package leetcode.com.algorithms.algorithmI;

public class FirstBadVersion {
 /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public static void main(String[] args){
        int bad = firstBadVersion(2);
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
                bad++;
                start = bad;
            }
        }
        return bad;
    }

}
