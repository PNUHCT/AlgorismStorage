import java.util.*;

public class reference {
    public static void main(String[] args) {
        int[][] room = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};

        System.out.println(robotPath(room, src, dst));
    }

    public static int robotPath(int[][] room, int[] src, int[] dst) {
        room = aux(room.length, room[0].length, src, 1, room);

        return room[dst[0]][dst[1]] - 1;
    }

    public static int[][] aux(int M, int N, int[] candi, int step, int[][] room) {
        // 현재 위치
        int row = candi[0];
        int col = candi[1];

        if (row < 0 || row >= M || col < 0 || col >= N) return room;

        if (room[row][col] == 0 || room[row][col] > step) {
            room[row][col] = step;
        } else {
            return room;
        }

        aux(M, N, new int[]{row + 1, col}, step + 1, room); // 하
        aux(M, N, new int[]{row - 1, col}, step + 1, room); // 상
        aux(M, N, new int[]{row, col - 1}, step + 1, room); // 좌
        aux(M, N, new int[]{row, col + 1}, step + 1, room); // 우

        return room;
    }
}