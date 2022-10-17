import java.util.*;

public class sudoku {
    static int [][] result;
    static boolean [][] rowCheck, colCheck, squCheck;
    static ArrayList<int[]> blanks;

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 3, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };
        int[][] output = sudoku(board);
        System.out.println(output); // -->
        /*
        [
          [4, 3, 5, 2, 6, 9, 7, 8, 1],
          [6, 8, 2, 5, 7, 1, 4, 9, 3],
          [1, 9, 7, 8, 3, 4, 5, 6, 2],
          [8, 2, 6, 1, 9, 5, 3, 4, 7],
          [3, 7, 4, 6, 8, 2, 9, 1, 5],
          [9, 5, 1, 7, 4, 3, 6, 2, 8],
          [5, 1, 9, 3, 2, 6, 8, 7, 4],
          [2, 4, 8, 9, 5, 7, 1, 3, 6],
          [7, 6, 3, 4, 1, 8, 2, 5, 9]
        ];
         */
    }

    public static int[][] sudoku(int[][] board) {
        result = new int[9][9];
        rowCheck = new boolean[9][10]; // 0~9까지 숫자가 있는 9행의 2차원 배열
        colCheck = new boolean[9][10]; // 0~9까지 숫자가 있는 9열의 2차원 배열
        squCheck = new boolean[9][10]; // 0~9까지 숫자가 있는 9박스의 2차원 배열
        blanks = new ArrayList<int[]>();

        for(int y=0 ; y<9 ; y++) {
            for(int x=0 ; x<9 ; x++) {
                result[y][x] = board[y][x]; // 결과에 보드의 각 숫자를 하나씩 복사
                if(result[y][x] == 0) {     // 이번 위치가 빈칸일 때 대처
                    blanks.add(new int[]{y,x}); // {i,j}는 빈칸이라고 메모해두는 용도
                }
                else { // 이번 위치가 빈칸이 아닐 때 대처
                    rowCheck[y][result[y][x]] = true; // i번째 행의 해당 숫자는 사용했다고 체크 (가로 중복 없애기)
                    colCheck[x][result[y][x]] = true; // j번째 열의 해당 숫자는 사용했다고 체크 (세로 중복 없애기)
                    squCheck[(y/3*3)+(x/3)][result[y][x]] = true;
                }
            }
        }
        tracking(0);
        return result;
    }

    public static boolean tracking(int count) {
        if(count==blanks.size()) return true;

        int[] data = blanks.get(count); // 비어있다고 표시한 좌표값
        int y = data[0]; // y좌표 (세로)
        int x = data[1]; // x좌표 (가로)

        for(int i=1 ; i<=9 ; i++) { // 각 Check 2차원 배열들을 순회할 것이므로(첫번째 자리인 0은 제외)
            if(rowCheck[y][i] | colCheck[x][i] || squCheck[y/3*3 + (x/3)][i]) continue; // 쓸 수 있는 숫자인지 확인

            // 각 제약조건에 맞춰 i라는 숫자 썼다고 체크하는 부분
            rowCheck[y][i] = true;
            colCheck[x][i] = true;
            squCheck[y/3*3+(x/3)][i] = true;
            result[y][x] = i; //

            // 다음 빈칸으로
            if(tracking(count+1)) return true;

            // 원상복구
            rowCheck[y][i] = false;
            colCheck[x][i] = false;
            squCheck[y/3*3+(x/3)][i] = false;
            result[y][x] = 0;
        }
        return false;
    }
}
