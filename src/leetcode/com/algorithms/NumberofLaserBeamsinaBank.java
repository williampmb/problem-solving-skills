package leetcode.com.algorithms;

public class NumberofLaserBeamsinaBank {
    public int numberOfBeams(String[] bank) {
        
        int beams = 0;
        int prevRow = 0;
        for(int i = 0 ; i < bank.length; i++){
            String row = bank[i];
            int curRow = 0;
            for(int j = 0; j < row.length(); j++){
                if(row.charAt(j)=='1'){
                    curRow++;
                }
            }
            if(curRow == 0){
                continue;
            }
            beams += prevRow * curRow;
            prevRow = curRow;
        }
        return beams;
    }
}
