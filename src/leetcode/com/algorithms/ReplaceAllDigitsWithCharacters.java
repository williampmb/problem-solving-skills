package leetcode.com.algorithms;

public class ReplaceAllDigitsWithCharacters{

    public static void main(String[] args){
        String v = replaceDigits("a1b2c3d4e");
        System.out.println(v);
    }

    public static String replaceDigits(String s) {
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < chars.length; i++ ){
            if(i%2==0){
                sb.append(chars[i]);
            }else{
                sb.append(shift(chars[i-1],Integer.valueOf(chars[i]+"")));
            }
        }

        return sb.toString();
    }

    public static char shift(char c, int v){
        int v1 = Integer.valueOf(v+"");
        return (char)(c+ v1);
    }
}