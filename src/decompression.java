import java.util.*;

public class decompression {
    public static String decompression(int[][] image) {
        String result = null;



        return result;
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
        System.out.println(result1); // --> "XX100110X1100​"

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
