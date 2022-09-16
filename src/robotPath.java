import java.util.Arrays;

public class robotPath {
    public static void main(String[] args) {
        int[][] room = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 3, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 2, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
    }

    public int robotPath(int[][] room, int[] src, int[] dst) {
        //----------------
        int curTime = 1; // 경과시간
        int minTime = 10000; // 최단시간
        int[] curPoint = Arrays.copyOf(src, src.length); // 말의 위치 = 현재위치
        int M = room.length;
        int N = room[0].length;
        //----------------
        int[][] field = new int[M][N]; // 맵을 복사한 가상 맵
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                field[i][j] = room[i][j];
            }
        }
        //----------------

        search(curPoint, M, N, curTime, field);

        minTime = field[dst[0]][dst[1]];

        return minTime;
    }

    public static int[][] search(int[]curPoint, int M, int N, int step, int[][] field) {
        int row = curPoint[0];
        int column = curPoint[1];

        // 필드를 벗어나는 경우, 바뀌기 전의 필드를 리턴
        if(row < 0 || row >= M || column < 0 || column >= N) return field;
        // 필드를 벗어나지 않을 경우 또는 (다음조건 이해안됨)
        if(field[row][column] == 0 || field[row][column] > step) {
            field[row][column] = step;
        } else {
            return field;
        }

        search(new int[]{row - 1, column}, M, N, step+1, field); // 상
        search(new int[]{row + 1, column}, M, N, step+1, field); // 하
        search(new int[]{row, column - 1}, M, N, step+1, field); // 좌
        search(new int[]{row, column + 1}, M, N, step+1, field); // 우

        return field;
    };
}
