import java.util.Arrays;

public class reference {
    public static void main(String[] args) {
//        int output = LIS(new int[]{3, 2});
//        System.out.println(output); // --> 1 (3 or 2)

        int output = LIS(new int[]{3, 10, 2, 1, 20});
        System.out.println(output); // --> 3 (3, 10, 20)
    }

    public static int LIS(int[] arr) {
        int N = arr.length;
        int[] lis = new int[N]; // 배열의 특정 인자까지 도달할 수 있는 경우를 카운트하는 배열
        Arrays.fill(lis, 1); // 자기 자신만 카운트하는건 무조건 있으니 전부 1가지 경우는 있는걸로 시작
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1; // 만약 무탈히 도달하면 카운트 +1
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();  // lis에서 카운트 한 애들 중 가장 큰 애 리턴
    }
}
