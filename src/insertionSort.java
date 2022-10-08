import java.util.Arrays;

public class insertionSort {
    // 조건
    public static void main(String[] args) {
        int[] output = insertionSort1(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        int[] input = new int[10000];
        for (int i = 0; i < 10000; i++) input[i] = i;
        int[] output1 = insertionSort1(input);
        System.out.println(Arrays.toString(output1));
        int[] output2 = insertionSort2(input);
        System.out.println(Arrays.toString(output2));

    }

    // 최대길이 1000미만의 자연수의 배열을 정렬하기만 하면 되는경우
    public static int[] insertionSort1(int[] arr) {
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) count++;
            }
            output[count] = arr[i];
        }
        return output;
    }

    // 최대길이가 1000이상인 자연수의 배열을 정렬해야 하는 경우
    public static int[] insertionSort2(int[] arr) {
        for (long index = 1; index < arr.length; index++) {
            long target = index;
            while (target > 0 && arr[(int) (target - 1)] > arr[(int) target]) {
                long temp = arr[(int) (target - 1)];
                arr[(int) (target - 1)] = arr[(int) target];
                arr[(int) target] = (int) temp;
                target--;
            }
        }
        return arr;
    }
}
