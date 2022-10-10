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
        int[] lis = new int[N];
        Arrays.fill(lis, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }
}
