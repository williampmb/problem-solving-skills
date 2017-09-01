/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingbat.com;

/**
 *
 * @author willi
 */
public class String3 {
    public static void main(String[] args){
        String base = "This is a FISH";
        String remove = "IS";
        String inp = "";
        String withoutString = withoutString(base, remove);
        int sum = sumNumbers(inp);
        System.out.println(withoutString);
    }
    
//---------------------
public static String withoutString(String base, String remove) {
    char first = Character.toLowerCase(remove.charAt(0));
    char[] without = new char[base.length()];
    int pointer =0, posWithout = 0;
    int removeLength = remove.length();
    int baseLength = base.length();
    
    while(pointer <= baseLength - removeLength){
        char letter =  Character.toLowerCase(base.charAt(pointer));
        if(letter == first){
            if(base.substring(pointer,pointer+removeLength)
                    .toLowerCase().equals(remove.toLowerCase())){
                pointer+= removeLength;
            }else{
                without[posWithout++] = base.charAt(pointer);
                pointer++;
            }
        }else{
            without[posWithout++] = base.charAt(pointer);
            pointer++;
        }
    }
    
    while(pointer < baseLength){
        without[posWithout++] = base.charAt(pointer);
        pointer++;
    }
    
    return new String(without,0,posWithout);
}

//-------------------------------
public static int sumNumbers(String str) {
    if(str == null) return 0;
    int ptLeft = 0, ptRight =0, sum =0;
    for(int i = 0 ; i < str.length() ; i++){
        if(Character.isDigit(str.charAt(i))){
          ptLeft = i;
          ptRight = ptLeft +1;
          while(ptRight < str.length() && Character.isDigit(str.charAt(ptRight))){
            ptRight++;
          }
          i = ptRight-1;
          int numb = Integer.parseInt(str.substring(ptLeft,ptRight));
          sum += numb;
        }
    }
    return sum;
}
    
    //----------
}
