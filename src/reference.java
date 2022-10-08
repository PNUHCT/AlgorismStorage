import java.util.*;

// 순서값만 구하는 공식, 조합의 내용은 알 수 없으나, 순서값을 빠르게 구할 수 있음
public class reference {
    public static void main(String[] args) {
        int[] N = {1, 2, 3};
        int a = orderOfPresentation(3, new int[]{2,3,1});
        System.out.println(a);
    }

    // 순서 구하는 메서드
    public static int orderOfPresentation(int N, int[] K) {
        // 순서값
        int order = 0;
        // 처음엔 전부 false. 사용된 숫자의 위치는 true가 될 것임. 0번째 인덱스는 더미데이터(무시값)
        boolean[] isUsed = new boolean[N + 1];

        for (int i = 0; i < K.length; i++) {
            // num은 비교할 배열 K의 i번째 요소 값
            int num = K[i];
            // i번째 요소가 사용됬으므로, 해당 위치는 true로 변경
            isUsed[num] = true;
            // 더미 데이터를 제외한 업데이트된 isUsed[]에서, i번째보다 앞쪽까지만 복사. 즉, 앞에 들어갈 수 있는 경우의 수 구할 목적
            boolean[] candidates = Arrays.copyOfRange(isUsed, 1, num);
            // 순서대로 일 때, num보다 앞에 올 수 있는 숫자 개수 구하기. false만 세므로 사용 안한애만 셈. 그 갯수는 validCnt
            int validCnt = 0;
            for (boolean candidate : candidates) if (!candidate) validCnt++;
            // 사용안한 숫자들마다 가질 수 있는 조합의 경우의 수를 구함
            // 즉. 현재 숫자보다 앞에 올수 있는 숫자개수 * 그 숫자마다 가질 수 있는 경우의 수 중 이미 사용한 i개를 뺸 경우의 수
            int formerCnt = validCnt * factorial(N - i - 1);

            // 최종 반환할 순서값 order = 현재까지의 경우의 수 + 방금 구한 경우의 수
            order = order + formerCnt;
        }
        // 즉, 사용한 숫자들을 제외하고. 현재 지정된 값의 앞에 올 수 있는 경우의 수를 더하면 최종 순서값이 나옴
        // 이때, index는 0부터 시작이므로, order번째랑 같음
        return order;
    }

    // 팩토리얼 공식
    public static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
