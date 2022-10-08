import java.util.Arrays;

public class reference {
    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        int [] input = new int[10000];
        for(int i = 0 ; i < 10000 ; i++) input[i] = i;
        int[] output1 = insertionSort(input);
        System.out.println(Arrays.toString(output1));
    }

    /*
      최적화를 적용한 코드
      : 이미 정렬된 숫자보다 큰 수를 비교하는 경우를 제거함으로써,
        불필요한 처리과정을 최소화  
    */
    public static int[] insertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int target = index;
            while (target > 0 && arr[target - 1] > arr[target]) {
                int temp = arr[target - 1];
                arr[target - 1] = arr[target];
                arr[target] = temp;
                target--;
            }
        }
        return arr;
    }
}
