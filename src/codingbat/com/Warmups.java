/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingbat.com;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author willi
 */
public class Warmups {
     public static void main(String[] args){
        int[] a = {3, 1, 1, 3, 4, 4};
        a = fix34(a);
        for(int i : a){
            System.out.print(i);

        }
     }

    private static int last2(String str) {
        if(str == null || str.length() == 0 || str.length() == 1) return 0;
	String match = str.substring(str.length()-2,str.length());
	int count =0;
	for(int i = 0 ; i < str.length()-2; i++){
            String conc = ""+str.charAt(i)+""+str.charAt(i+1)+"";
            if(conc.equals(match)) count++;
	}
	return count;
    }
    
    public static int arrayCount9(int[] nums){
        if(nums == null || nums.length ==0) return 0;
        int count =0;
        for(int i = 0 ; i < nums.length ; i++) 
                if(nums[i]==9) count++;
        return count;
    }
    
    public static boolean arrayFront9(int[] nums){
        if(nums == null || nums.length ==0) return false;
        int i =0;
        for(i = 0 ; i < nums.length ; i++){
            if(i == 4) break;
            if(nums[i]==9) return true;
        } 
        return false;
    }
    
    public static int maxSpan(int[] nums){
	if(nums == null || nums.length == 0) return 0;
	if(nums.length == 1) return 1;
	int max = 1;
	Map<Integer,Integer> db = new Hashtable<>();
	for(int i = 0 ; i < nums.length;i++){
		if(db.get(nums[i])== null){
			db.put(nums[i],1);
		}else{
			int qt = db.get(nums[i]);
			qt++;
			db.put(nums[i],qt);
		}
	}
        Collection<Integer> values = db.keySet();
        Iterator<Integer> iterator = values.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            Integer get = db.get(next);
            if(get>1){
                int left=0,right=0;
                for(int i = 0 ; i < nums.length;i++){
                    if(nums[i]==next){
                        left = i;
                        break;
                    }
                }
                 for(int i = nums.length-1 ; i > -1;i--){
                    if(nums[i]==next){
                        right = i;
                        break;
                    }
                }
                max = max > right-left+1? max:right-left+1;
            }
        }
     
	return max; 
    }
    
    public static int[] fix34(int[] nums){
        LinkedList<Integer> four = new LinkedList<>();
        LinkedList<Integer> fix3 = new LinkedList<>();
	
	for(int i = 0 ; i < nums.length; i++){
		if(nums[i] == 4){
			if(i == 0 || nums[i-1] != 3) four.push(i);
		}else if(nums[i] == 3){
                    if(nums[i+1]== 4) continue;
                    if(four.isEmpty()){
                        fix3.push(i);
                    }else{
                        if(nums[i+1]!= 4){
                            nums = switchNumb(four.pop(),i+1,nums);
                        }
                    }
		}
	}
	while(!fix3.isEmpty()){
            int pos3 = fix3.pop();
            int pos4 = four.pop();
            nums = switchNumb(pos4,pos3+1,nums);
           
	}
	return nums;
    }
    
    public static int[] switchNumb(int four, int other, int[] array ){
	int tmp = array[other];
	array[other] = 4;
	array[four] = tmp;
	return array;
    }
    
//--------------------------------
public int[] fix45(int[] nums) {
  if(nums == null) return nums;
  if(nums.length < 3) return nums;
  
  for(int i = 0 ; i < nums.length-1; i++){
    if(nums[i] == 4 && nums[i+1] != 5){
      int pos5 = findNext5(nums);
      nums = switchNumbs(pos5,i+1,nums);
    }  
  }
  return nums;
}

public int findNext5(int[] nums){
  for(int i = 0 ; i< nums.length;i++){
    if(i==0 && nums[i] ==5){
      return i;
    }else if(nums[i]==5 && nums[i-1] != 4){
      return i;
    }
  }
  //print some erro;
  return -1;
}

public int[] switchNumbs(int pos5, int posSwitch,int[] nums){
  int tmp = nums[posSwitch];
  nums[posSwitch] = nums[pos5];
  nums[pos5] = tmp;
  return nums;
}
//-----------------------------


public boolean canBalance(int[] nums) {
  if(nums == null || nums.length == 1) return false;
  
  int sumLeft = 0, sumRight= 0;
  for(int i =0 ; i < nums.length ; i++)
    sumLeft += nums[i];
  
  for(int j = nums.length-1; j>0; j--){
    sumRight += nums[j];
    sumLeft -= nums[j];
    if(sumRight == sumLeft) return true;
  }
  
  return false;
}
//-------------------------------------
public boolean linearIn(int[] outer, int[] inner) {
  if(inner == null || inner.length == 0) return true;
  int pInner =0, pOuter =0;
  int inLenght = inner.length, outLength = outer.length;
  while(pOuter < outLength && pInner < inLenght){
    int in = inner[pInner];
      while(pOuter < outLength){
        if(in == outer[pOuter]){
          pOuter++;
          break;
        }else if(pOuter+1 > outLength-1 && pInner < inLenght){
          return false;
        } 
        pOuter++;
      }
    pInner++;
  }
  if(pInner < inLenght) return false;
  return true;
}


//-------------------


}
