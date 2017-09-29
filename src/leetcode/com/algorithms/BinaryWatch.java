/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willi
 */
public class BinaryWatch {

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();

        List<String> readBinaryWatch = bw.readBinaryWatch(6);
    }

    public List<String> readBinaryWatch(int num) {
        if (num > 10 || num < 0) {
            return new ArrayList<>();
        }

        int min = minimumNumbWithOnes(num);
        int max = maximumNumbWithOnes(num);
        List<String> result = new ArrayList();
        String time = convertToString(min);
        if (time != null) {
            result.add(convertToString(min));

        }

        while (min < max) {
            min++;
            boolean checked = checkNumbOnes(min, num);
            if (checked) {
                time = convertToString(min);
                if (time != null) {
                    result.add(convertToString(min));
                }

            }
        }
        return result;
    }

    private int minimumNumbWithOnes(int minimum) {
        return ~(~0 << minimum);
    }

    private int maximumNumbWithOnes(int maximum) {
        int mask1 = (~0 << 10 - maximum);
        int mask2 = ~(~0 << 10);
        return (mask1 & mask2);
    }

    private String convertToString(int binaryTime) {
        StringBuilder time = new StringBuilder();
        int hours = getHours(binaryTime);
        int minutes = getMinutes(binaryTime);
        if (hours > 11 || minutes > 59) {
            return null;
        }

        time.append(hours);

        if (minutes < 10) {
            time.append(":0" + minutes);
        } else {
            time.append(":" + minutes);
        }
        System.out.println(time.toString());
        return time.toString();
    }

    private int setBit(int binaryTime, int pos) {
        int mask = (1 << pos);
        return binaryTime | mask;
    }

    private int clearBit(int binaryTime, int pos) {
        int mask = ~(1 << pos);
        return binaryTime & mask;
    }

    private int getHours(int binaryTime) {
        return binaryTime >> 6;
    }

    private int getMinutes(int binaryTime) {
        int mask = ~(~0 << 6);
        return mask & binaryTime;
    }

    private boolean checkNumbOnes(int min, int num) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int bit = getBit(min, i);
            if (bit != 0) {
                count++;
            }
            if (count > num) {
                return false;
            }
        }
        return num == count ? true : false;
    }

    private int getBit(int min, int i) {
        int mask = 1 << i;
        return min & mask;
    }

}
