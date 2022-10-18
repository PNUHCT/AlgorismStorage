import java.util.*;

public class reference {
    public static String decompression(int[][] image) {
        return aux(0, image.length - 1, 0, image.length - 1, image);
    }

    public static String aux(int rs, int re, int cs, int ce, int[][] image) {
        if (rs == re) return String.valueOf(image[rs][cs]);

        int midRow = (int)Math.floor((rs + re) / 2);
        int midCol = (int)Math.floor((cs + ce) / 2);
        String leftUpper = aux(rs, midRow, cs, midCol, image);
        String rightUpper = aux(rs, midRow, midCol + 1, ce, image);
        String leftDown = aux(midRow + 1, re, cs, midCol, image);
        String rightDown = aux(midRow + 1, re, midCol + 1, ce, image);

        String result = leftUpper + rightUpper + leftDown + rightDown;
        if (result.equals("1111")) return "1";
        else if (result.equals("0000")) return "0";
        else return "X" + result;
    }


    // 엔트리 포인트 --------------------------------
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        String result1 = decompression(image);
        System.out.println(result1); // --> "XX100110X1100"

        image = new int[][]{
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1}
        };
        String result2 = decompression(image);
        System.out.println(result2); // --> 'X0X101X10101X00X10011'
    }
}
