package quintoandar;

public class second {
    public static void main(String[] args) {

        int[] arr = new int[] { 2 };

        System.out.println(solution(1, ""));
    }

    // how many seats are available to family of 3 group
    // plane scheme N* (3-4-3)
    public static int solution(int N, String S) {

        boolean[][] plane = new boolean[N + 1][10];
        String[] seats = S.split(" ");
        int familySpace = 0;

        if (S.equals("")) {
            return N * 3;
        }

        for (String seat : seats) {
            int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
            int col = getPlaneColumn(seat.substring(seat.length() - 1));
            plane[row][col] = true;
        }

        for (int row = 1; row < plane.length; row++) {
            if (!plane[row][0] && !plane[row][1] && !plane[row][2]) {
                familySpace++;
            }

            if (!plane[row][3] && !plane[row][4] && !plane[row][5]
                    || !plane[row][4] && !plane[row][5] && !plane[row][6]) {
                familySpace++;
            }

            if (!plane[row][7] && !plane[row][8] && !plane[row][9]) {
                familySpace++;
            }
        }

        return familySpace;
    }

    public static int getPlaneColumn(String col) {
        char column = col.toCharArray()[0];
        if (column == 'J' || column == 'K') {
            return column - 'A' - 1;
        }
        return column - 'A';

    }
}
