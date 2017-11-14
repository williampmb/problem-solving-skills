/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

/**
 *
 * @author willi
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        boolean absent = false;
        int length = s.length();
        for(int i = 0 ; i < length;i++){
            char attendence = s.charAt(i);
            if(attendence == 'A'){
                if(absent == true) return false;
                absent = true;
            }else if(attendence == 'L' && i >1 ){
                if(s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') return false;
            }
        }
        return true;
    }
}
