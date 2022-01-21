package leetcode.com.algorithms;

//https://leetcode.com/problems/lemonade-change/
public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int mybills[] = {0,0,0};

        for(int bill : bills){
            int change = bill-5;
            boolean has = hasChange(change, mybills);
            if(!has) return false;
            addBill(bill,mybills);
        }

        return true;
    }

    public static void addBill(int bill, int[] mybills){
        if(bill==20 ){
            mybills[2]++;
        }else if(bill==10){
            mybills[1]++;
        }else {
            mybills[0]++;
        }
    }

    public static boolean hasChange(int change, int bills[]){
        if(change ==0) return true;
        while(change>0){
            if(change>=20 && bills[2]>0){
                change-=20;
                bills[2]--;
            }else if(change>=10 && bills[1]>0){
                change-=10;
                bills[1]--;
            }else if(change>=5 && bills[0]>0){
                change-=5;
                bills[0]--;
            }else{
                return false;
            }
        }

        return true;
    }
}