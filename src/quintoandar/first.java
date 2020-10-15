package quintoandar;

public class first {
    public static void main(String[] args) {

        int[] arr = new int[] { 2 };

        System.out.println(solution(arr));
    }

    // how many castles can be built in valley and hill
    public static int solution(int[] A) {

        int length = A.length, count = 0;
        boolean up = true, down = true;
        for (int i = 0; i < length - 1; i++) {
            if (A[i] < A[i + 1] && up) {
                count++;
                down = true;
                up = false;
            } else if (A[i] > A[i + 1] && down) {
                count++;
                up = true;
                down = false;
            }
        }

        return count + 1;
    }

}
