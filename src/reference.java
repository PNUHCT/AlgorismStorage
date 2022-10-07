import java.util.*;

public class reference {
    public static void main(String[] args) {
        int output = LCS("abcd", "aceb");
        System.out.println(output); // --> 2 ("ab" or "ac")

        output = LCS("acaykp", "capcak");
        System.out.println(output); // --> 4 ("acak")
    }

    public static int LCS(String str1, String str2) {
        // dynamic programming: O(M * N)
        // memoization을 활용해 중복 계산되는 문제를 제거한다.
        // LCS('ABCD', 'ACEB')의 경우 재귀 호출을 적어보면 아래와 같다.
        // => 1) LCS('BCD', 'CEB')
        //  => 1-1) LCS('CD', 'CEB'), 1-2) LCS('BCD', 'EB')
        //    => 1-1-1) LCS('D', 'CEB'), 1-1-2) LCS('CD', 'EB')
        //    => 1-2-1) LCS('CD', 'EB'), 1-2-2) LCS('BCD', 'B')
        // 더 볼 필요 없이 1-1-2)와 1-2-1)은 같은 문제임을 알 수 있다.
        int M = str1.length();
        int N = str2.length();
        // 중복 계산을 방지하기 위해 left, right
        int[][] memo = new int[M + 1][N + 1];
        for(int[] data : memo) Arrays.fill(data, -1);

        return compareOneByOne(0, 0, 0, memo, str1, str2);

    }
    public static int compareOneByOne(int left, int right, int len, int[][] memo, String str1, String str2) {
        if (memo[left][right] != -1) return memo[left][right];

        if (left == str1.length() || right == str2.length()) return 0;

        if (str1.charAt(left) == str2.charAt(right)) {
            memo[left][right] = 1 + compareOneByOne(left + 1, right + 1, len + 1, memo, str1, str2);
            return memo[left][right];
        }

        memo[left][right] = Math.max(
                compareOneByOne(left + 1, right, len, memo, str1, str2),
                compareOneByOne(left, right + 1, len, memo, str1, str2)
        );
        return memo[left][right];
    }
}
