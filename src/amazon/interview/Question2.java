package amazon.interview;

public class Question2 {

    public static void main(String[] args) {
        System.out.println(3 % 9);
        // int[] a = { 2, 3, 4, 5, 6 };
        // int g = generalizedGCD(5, a);
        // System.out.println(g);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static public int generalizedGCD(int num, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        int gcd = arr[0];
        for (int i = 1; i < num; i++) {
            gcd = gcd(gcd, arr[i]);
        }
        return gcd;
    }

    static public int gcd(int x, int y) {
        while (y > 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }
}