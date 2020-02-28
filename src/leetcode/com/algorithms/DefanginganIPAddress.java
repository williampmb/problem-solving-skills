package leetcode.com.algorithms;

public class DefanginganIPAddress {
    public String defangIPaddr(String address) {
        char[] charArray = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}