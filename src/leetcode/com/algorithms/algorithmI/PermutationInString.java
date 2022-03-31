package leetcode.com.algorithms.algorithmI;

public class PermutationInString {

    public static void main(String[] args){

        checkInclusion("adc","dcda");
        //checkInclusion("ab","aedbaooo");

    }
 
    public static boolean checkInclusion(String s1, String s2) {
        
        int[] db = new int[26];

        db = fill(s1);

        int s1Length = s1.length();
        int s2Length = s2.length();
       
        int right = 0;
        while(right < s1Length && right<s2Length){
            int pos = s2.charAt(right);
            db[pos-'a']--;
            right++;
        }

        if(isDbEmpty(db)){
            return true;
        }
        int left =0;
        while(right<s2Length){
            char v = s2.charAt(right++);
            int pos = v;
            db[pos-'a']--;
            v = s2.charAt(left++);
            pos = v;
            db[pos-'a']++;
            if(isDbEmpty(db)){
                return true;
            }
        }

        return false;
    }

    private static boolean isDbEmpty(int[] db) {
        for(int i : db){
            if(i!=0) return false;
        }
        return true;
    }

    public static int[] fill(String s){
        int[] db = new int[26];
        for(int i : s.toCharArray()){
            db[i-'a']++;
        }

        return db;
    }

    
}
